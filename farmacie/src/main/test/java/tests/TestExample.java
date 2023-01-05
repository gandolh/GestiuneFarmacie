package tests;

import org.junit.Test;
import static org.junit.Assert.*;
import gestiune.farmacie.controllers.CreateUpdateAccountController;


public class TestExample {

    @Test
    public void testValidateUsername(){
        CreateUpdateAccountController controller = new CreateUpdateAccountController();
        assertTrue(controller.validateUserName("test"));
        assertTrue(controller.validateUserName("tes123"));
        assertFalse(controller.validateUserName("test@123"));
        assertFalse(controller.validateUserName("test.123"));
    }

    @Test
    public void testValidateFirstname(){
        CreateUpdateAccountController controller = new CreateUpdateAccountController();
        assertTrue(controller.validateFirstName("Test"));
        assertTrue(controller.validateFirstName("Popescu"));
        assertFalse(controller.validateFirstName("test"));
        assertFalse(controller.validateFirstName("Popescu1"));
    }

    @Test
    public void testValidateLastName(){
        CreateUpdateAccountController controller = new CreateUpdateAccountController();
        assertTrue(controller.validateLastName("Test"));
        assertTrue(controller.validateLastName("Matei"));
        assertFalse(controller.validateLastName("test"));
        assertFalse(controller.validateLastName("Matei@"));
    }

    @Test
    public void testValidateEmail(){
        CreateUpdateAccountController controller = new CreateUpdateAccountController();
        assertTrue(controller.validateEmail("test@gmail.com"));
        assertTrue(controller.validateEmail("GenericEmail123@gmail.ro"));
        assertFalse(controller.validateEmail("test@.c"));
        assertFalse(controller.validateEmail("@@@test@gmail.comkk"));
    }

    @Test
    public void testValidateBirthdate(){
        CreateUpdateAccountController controller = new CreateUpdateAccountController();
        assertTrue(controller.validateBirthdate("13/12/2002"));
        assertTrue(controller.validateBirthdate("04/07/2002"));
        assertFalse(controller.validateBirthdate("32/01/2002"));
        assertFalse(controller.validateBirthdate("05/05/100"));
    }

    @Test
    public void testValidateHiredate(){
        CreateUpdateAccountController controller = new CreateUpdateAccountController();
        assertTrue(controller.validateHiredate("13/12/2002"));
        assertTrue(controller.validateHiredate("04/07/2002"));
        assertFalse(controller.validateHiredate("32/01/2002"));
        assertFalse(controller.validateHiredate("05/05/100"));
    }


    @Test
    public void testValidate(){
        CreateUpdateAccountController controller = new CreateUpdateAccountController();
        assertTrue(controller.validate("testUser","Ion","Popescu","test@gmail.com","01/01/2000","16/08/2020"));
        assertFalse(controller.validate("test123","ion","popescu","test@@gmail.com","10/200/2001","60/17/2020"));
    }



}




