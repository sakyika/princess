-- Create patient permission

call createPatientPermission ('CTRL_PATIENT_USER_LIST_GET');
call createPatientPermission ('CTRL_PATIENT_USER_ADD_POST');
call createPatientPermission ('CTRL_PATIENT_USER_UPDATE_PUT');
call createPatientPermission ('CTRL_PATIENT_USER_DELETE_DELETE');

call createPatientPermission ('CTRL_PATIENT_PERMISSION_LIST_GET');
call createPatientPermission ('CTRL_PATIENT_PERMISSION_ADD_POST');
call createPatientPermission ('CTRL_PATIENT_PERMISSION_UPDATE_PUT');
call createPatientPermission ('CTRL_PATIENT_PERMISSION_DELETE_DELETE');

call createPatientPermission ('CTRL_PATIENT_ROLE_LIST_GET');
call createPatientPermission ('CTRL_PATIENT_ROLE_ADD_POST');
call createPatientPermission ('CTRL_PATIENT_ROLE_UPDATE_PUT');
call createPatientPermission ('CTRL_PATIENT_ROLE_DELETE_DELETE');


-- Create patient roles

call createPatientRole('ROLE_MANAGER', @role_manager);

call createPatientRoleHasPatientPermission(@role_manager, 'CTRL_PATIENT_USER_LIST_GET');
call createPatientRoleHasPatientPermission(@role_manager, 'CTRL_PATIENT_USER_ADD_POST');
call createPatientRoleHasPatientPermission(@role_manager, 'CTRL_PATIENT_USER_UPDATE_PUT');
call createPatientRoleHasPatientPermission(@role_manager, 'CTRL_PATIENT_USER_DELETE_DELETE');

call createPatientRoleHasPatientPermission(@role_manager, 'CTRL_PATIENT_PERMISSION_LIST_GET');
call createPatientRoleHasPatientPermission(@role_manager, 'CTRL_PATIENT_PERMISSION_ADD_POST');
call createPatientRoleHasPatientPermission(@role_manager, 'CTRL_PATIENT_PERMISSION_UPDATE_PUT');
call createPatientRoleHasPatientPermission(@role_manager, 'CTRL_PATIENT_PERMISSION_DELETE_DELETE');

call createPatientRoleHasPatientPermission(@role_manager, 'CTRL_PATIENT_ROLE_LIST_GET');
call createPatientRoleHasPatientPermission(@role_manager, 'CTRL_PATIENT_ROLE_ADD_POST');
call createPatientRoleHasPatientPermission(@role_manager, 'CTRL_PATIENT_ROLE_UPDATE_PUT');
call createPatientRoleHasPatientPermission(@role_manager, 'CTRL_PATIENT_ROLE_DELETE_DELETE');


call createPatientRole('ROLE_DOCTOR', @role_doctor);

call createPatientRoleHasPatientPermission(@role_doctor, 'CTRL_PATIENT_USER_LIST_GET');
call createPatientRoleHasPatientPermission(@role_doctor, 'CTRL_PATIENT_USER_ADD_POST');
call createPatientRoleHasPatientPermission(@role_doctor, 'CTRL_PATIENT_USER_UPDATE_PUT');

call createPatientRoleHasPatientPermission(@role_doctor, 'CTRL_PATIENT_PERMISSION_LIST_GET');
call createPatientRoleHasPatientPermission(@role_doctor, 'CTRL_PATIENT_PERMISSION_ADD_POST');
call createPatientRoleHasPatientPermission(@role_doctor, 'CTRL_PATIENT_PERMISSION_UPDATE_PUT');

call createPatientRoleHasPatientPermission(@role_doctor, 'CTRL_PATIENT_ROLE_LIST_GET');
call createPatientRoleHasPatientPermission(@role_doctor, 'CTRL_PATIENT_ROLE_ADD_POST');
call createPatientRoleHasPatientPermission(@role_doctor, 'CTRL_PATIENT_ROLE_UPDATE_PUT');


call createPatientRole('ROLE_RECEPTIONIST', @role_receptionist);

call createPatientRoleHasPatientPermission(@role_receptionist, 'CTRL_PATIENT_USER_LIST_GET');
call createPatientRoleHasPatientPermission(@role_receptionist, 'CTRL_PATIENT_USER_ADD_POST');

call createPatientRoleHasPatientPermission(@role_receptionist, 'CTRL_PATIENT_PERMISSION_LIST_GET');
call createPatientRoleHasPatientPermission(@role_receptionist, 'CTRL_PATIENT_PERMISSION_ADD_POST');

call createPatientRoleHasPatientPermission(@role_receptionist, 'CTRL_PATIENT_ROLE_LIST_GET');
call createPatientRoleHasPatientPermission(@role_receptionist, 'CTRL_PATIENT_ROLE_ADD_POST');


call createPatientRole('ROLE_CASHIER', @role_cashier);

call createPatientRoleHasPatientPermission(@role_cashier, 'CTRL_PATIENT_USER_LIST_GET');

call createPatientRoleHasPatientPermission(@role_cashier, 'CTRL_PATIENT_PERMISSION_LIST_GET');

call createPatientRoleHasPatientPermission(@role_cashier, 'CTRL_PATIENT_ROLE_LIST_GET');



-- Create users

call createPatientUser('manager', '$2a$10$eb8d55FvKfErll4VgxpGBu7s/Xl/IPRmsT0v17Epw.gBwyWjmc.6.', 1, @manager);
call createPatientUserHasPatientRole(@manager, @role_manager);

call createPatientUser('doctor', '$2a$10$MBp4Iv1CHEtKE0Js0X9RNermfIIzCNxdtC7Ij/UIb6dlsVq9uTLLK', 1, @doctor);
call createPatientUserHasPatientRole(@doctor, @role_doctor);

call createPatientUser('receptionist', '$2a$10$E.aUP3urQLfhrpQLCbmNcuZeUs2XSAu38fzo8K.9KQ8nqT52klUHG', 1, @receptionist);
call createPatientUserHasPatientRole(@receptionist, @role_receptionist);

call createPatientUser('cashier', '$2a$10$tIQ.S6EgRBEjzehKqgZh8u7XmvwkueyuR1H3S7jd9LyoBET6DH.Ty', 1, @cashier);
call createPatientUserHasPatientRole(@cashier, @role_cashier);




