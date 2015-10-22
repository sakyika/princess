-- Create patient permission

call createPatientPermission ('CTRL_PATIENT_USER_LIST_GET');
call createPatientPermission ('CTRL_PATIENT_USER_ADD_POST');
call createPatientPermission ('CTRL_PATIENT_USER_UPDATE_PUT');
call createPatientPermission ('CTRL_PATIENT_USER_LIST_DELETE');

call createPatientPermission ('CTRL_PATIENT_PERMISSION_LIST_GET');
call createPatientPermission ('CTRL_PATIENT_PERMISSION_ADD_POST');
call createPatientPermission ('CTRL_PATIENT_PERMISSION_UPDATE_PUT');
call createPatientPermission ('CTRL_PATIENT_PERMISSION_LIST_DELETE');

call createPatientPermission ('CTRL_PATIENT_ROLE_LIST_GET');
call createPatientPermission ('CTRL_PATIENT_ROLE_ADD_POST');
call createPatientPermission ('CTRL_PATIENT_ROLE_UPDATE_PUT');
call createPatientPermission ('CTRL_PATIENT_ROLE_LIST_DELETE');


-- Create patient roles

call createPatientRole('ROLE_MANAGER', @role_manager);

call createPatientRoleHasPatientPermission(role_manager, 'CTRL_PATIENT_USER_LIST_GET');
call createPatientRoleHasPatientPermission(role_manager, 'CTRL_PATIENT_USER_ADD_POST');
call createPatientRoleHasPatientPermission(role_manager, 'CTRL_PATIENT_USER_UPDATE_PUT');
call createPatientRoleHasPatientPermission(role_manager, 'CTRL_PATIENT_USER_LIST_DELETE');

call createPatientRoleHasPatientPermission(role_manager, 'CTRL_PATIENT_PERMISSION_LIST_GET');
call createPatientRoleHasPatientPermission(role_manager, 'CTRL_PATIENT_PERMISSION_ADD_POST');
call createPatientRoleHasPatientPermission(role_manager, 'CTRL_PATIENT_PERMISSION_UPDATE_PUT');
call createPatientRoleHasPatientPermission(role_manager, 'CTRL_PATIENT_PERMISSION_LIST_DELETE');

call createPatientRoleHasPatientPermission(role_manager, 'CTRL_PATIENT_ROLE_LIST_GET');
call createPatientRoleHasPatientPermission(role_manager, 'CTRL_PATIENT_ROLE_ADD_POST');
call createPatientRoleHasPatientPermission(role_manager, 'CTRL_PATIENT_ROLE_UPDATE_PUT');
call createPatientRoleHasPatientPermission(role_manager, 'CTRL_PATIENT_ROLE_LIST_DELETE');


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



--Create users

call createPatientUser('manager', @manager);
call createPatientUserHasPatientRole(@manager, @role_manager);

call createPatientUser('doctor', @doctor);
call createPatientUserHasPatientRole(@doctor, @role_doctor);

call createPatientUser('receptionist', @receptionist);
call createPatientUserHasPatientRole(@receptionist, @role_receptionist);

call createPatientUser('cashier', @cashier);
call createPatientUserHasPatientRole(@cashier, @role_cashier);




