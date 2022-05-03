package com.example.springboot.parking.parkingservice;

import com.example.springboot.parking.parkingentity.TypeUser;
import com.example.springboot.parking.parkingentity.User;
import com.example.springboot.parking.parkingentity.Vehicle;
import com.example.springboot.parking.parkingrepository.TypeUserRepository;
import com.example.springboot.parking.parkingrepository.UserRepository;
import com.example.springboot.parking.parkingrequest.EmailRequest;
import com.example.springboot.parking.parkingrequest.RequestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TypeUserRepository typeUserRepository;

    public void addNewUser(User user){
        userRepository.save(user);
    }

    @ResponseStatus
    public void addNewUserRequest(RequestUser request) {

        TypeUser type = typeUserRepository.findById(request.getTypeUserId()).orElseThrow(() -> new IllegalStateException("Cedula is already registered "));
        Optional<User> userOptional = userRepository.findUserByCedula(request.getCedula());

        if(userOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Cedula is already registered ");
        }
        userRepository.save(new User(request, type));
        throw new ResponseStatusException(HttpStatus.ACCEPTED,"User Registered ");

    }

    @ResponseStatus
    public void deleteUser(User user){
        Optional<User> userOptional = userRepository.findUserByCedula(user.getCedula());
        if(userOptional.isPresent()){
            userRepository.delete(user);
            throw new ResponseStatusException(HttpStatus.OK,"El usuario ha sido eliminado ");
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se puede Eliminar, no se encontro la cedula ");
    }

    public void deleteUserRequest(RequestUser requestUser){
        Optional<User> userOptional = userRepository.findUserByCedula(requestUser.getCedula());
        if(userOptional.isPresent()){
            userRepository.delete(userOptional.get());
            throw new ResponseStatusException(HttpStatus.OK,"El usuario ha sido eliminado ");
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se puede Eliminar, no se encontro la cedula ");
    }

    /*public void deleteUserRequest(RequestUser requestUser){
        Optional<User> userOptional = userRepository.findUserByCedula(requestUser.getCedula());
        TypeUser typeUser=typeUserRepository.getById(requestUser.getTypeUserId());

        if(userOptional.isPresent()){
            User user=new User(requestUser, typeUser);
            userRepository.delete(user);
            throw new ResponseStatusException(HttpStatus.OK,"El usuario ha sido eliminado ");

        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se puede Eliminar, no se encontro la cedula ");

    }*/

    public List<User> listUsers(){
        return userRepository.findAll();
    }

    @Transactional
    public void updateUser(Long userId, String name, String cedula, String direction, String email,
                           /*Long typeUserId,*/ String password) {
        User user = userRepository.findById(userId).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with id "+userId+" does not exist"));
        if(name != null && name.length() > 0 &&
                !Objects.equals(user.getName(), name)){
            user.setName(name);
        }
        if(cedula != null && cedula.length() > 0 &&
                !Objects.equals(user.getCedula(),cedula)){
            Optional<User> studentOptional = userRepository.findUserByEmail(email);
            if(studentOptional.isPresent()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cedulas is already registered in other user");
            }
            user.setCedula(cedula);
            throw new ResponseStatusException(HttpStatus.OK, "Cedula Update");
        }
        if(email != null && email.length() > 0 &&
                !Objects.equals(user.getEmail(), email)){
            Optional<User> studentOptional = userRepository.findUserByEmail(email);
            if (studentOptional.isPresent()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"email taken");
            }
            user.setEmail(email);
            throw new ResponseStatusException(HttpStatus.OK, "Email Update");
        }
    }

    public void validateLogin(RequestUser requestUser) {
        Optional<User> optionalRequestEmail= userRepository.findUserByEmail(requestUser.getEmail());
        if(optionalRequestEmail.isPresent()){
            if (optionalRequestEmail.get().getTypeUserId().getId()==1L){
                if (Objects.equals(requestUser.getEmail(),optionalRequestEmail.get().getEmail())){
                    throw new ResponseStatusException(HttpStatus.ACCEPTED, "Bienvenido "+optionalRequestEmail.get().getName()+" User Admin" );
                }
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Contraseña Incorrecta");
            }
            if (Objects.equals(requestUser.getEmail(),optionalRequestEmail.get().getEmail())){
                throw new ResponseStatusException(HttpStatus.ACCEPTED, "Bienvenido "+optionalRequestEmail.get().getName());
            }
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Contraseña Incorrecta");
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se ha encontrado el usuario "+"\nPor Favor Verifique");

    }

    /*@ResponseStatus
    public void sendEmailRequest(EmailRequest emailRequest){
        Optional<User> userOptional = userRepository.findUserByEmail(emailRequest.getEmail());
        if(userOptional.isPresent()){
            System.out.println();
            throw new ResponseStatusException(HttpStatus.OK,"El Correo Ha Sido Enviado");
        }
        System.out.println("Metodo Send Email Request");
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"La placa a enviar correo no se encuentra registrada");
    }*/
}
