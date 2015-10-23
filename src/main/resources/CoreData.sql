-- Create core permissions

call createPermission('CTRL_USER_LIST_GET');
call createPermission('CTRL_USER_ADD_POST');
call createPermission('CTRL_USER_UPDATE_PUT');
call createPermission('CTRL_USER_DELETE_DELETE');

call createPermission('CTRL_ROLE_LIST_GET');
call createPermission('CTRL_ROLE_ADD_POST');
call createPermission('CTRL_ROLE_UPDATE_PUT');
call createPermission('CTRL_ROLE_DELETE_DELETE');

call createPermission('CTRL_PERM_LIST_GET');
call createPermission('CTRL_PERM_ADD_POST');
call createPermission('CTRL_PERM_UPDATE_PUT');
call createPermission('CTRL_PERM_DELETE_DELETE');


-- Create core roles

call createRole('ROLE_ADMIN', @role_admin);

call createRoleHasPermission(@role_admin, 'CTRL_USER_LIST_GET');
call createRoleHasPermission(@role_admin, 'CTRL_USER_ADD_POST');
call createRoleHasPermission(@role_admin, 'CTRL_USER_UPDATE_PUT');
call createRoleHasPermission(@role_admin, 'CTRL_USER_DELETE_DELETE');

call createRoleHasPermission(@role_admin, 'CTRL_ROLE_LIST_GET');
call createRoleHasPermission(@role_admin, 'CTRL_ROLE_ADD_POST');
call createRoleHasPermission(@role_admin, 'CTRL_ROLE_UPDATE_PUT');
call createRoleHasPermission(@role_admin, 'CTRL_ROLE_DELETE_DELETE');

call createRoleHasPermission(@role_admin, 'CTRL_PERM_LIST_GET');
call createRoleHasPermission(@role_admin, 'CTRL_PERM_ADD_POST');
call createRoleHasPermission(@role_admin, 'CTRL_PERM_UPDATE_PUT');
call createRoleHasPermission(@role_admin, 'CTRL_PERM_DELETE_DELETE');


call createRole('ROLE_SUPERVISOR', @role_supervisor);

call createRoleHasPermission(@role_supervisor, 'CTRL_USER_LIST_GET');
call createRoleHasPermission(@role_supervisor, 'CTRL_USER_ADD_POST');
call createRoleHasPermission(@role_supervisor, 'CTRL_USER_UPDATE_PUT');

call createRoleHasPermission(@role_supervisor, 'CTRL_ROLE_LIST_GET');
call createRoleHasPermission(@role_supervisor, 'CTRL_ROLE_ADD_POST');
call createRoleHasPermission(@role_supervisor, 'CTRL_ROLE_UPDATE_PUT');

call createRoleHasPermission(@role_supervisor, 'CTRL_PERM_LIST_GET');
call createRoleHasPermission(@role_supervisor, 'CTRL_PERM_ADD_POST');
call createRoleHasPermission(@role_supervisor, 'CTRL_PERM_UPDATE_PUT');


call createRole('ROLE_LEADER', @role_leader);

call createRoleHasPermission(@role_leader, 'CTRL_USER_LIST_GET');
call createRoleHasPermission(@role_leader, 'CTRL_USER_ADD_POST');

call createRoleHasPermission(@role_leader, 'CTRL_ROLE_LIST_GET');
call createRoleHasPermission(@role_leader, 'CTRL_ROLE_ADD_POST');

call createRoleHasPermission(@role_leader, 'CTRL_PERM_LIST_GET');
call createRoleHasPermission(@role_leader, 'CTRL_PERM_ADD_POST');


call createRole('ROLE_USER', @role_user);

call createRoleHasPermission(@role_user, 'CTRL_USER_LIST_GET');

call createRoleHasPermission(@role_user, 'CTRL_ROLE_LIST_GET');

call createRoleHasPermission(@role_user, 'CTRL_PERM_LIST_GET');

-- Create core users

call createUser('admin', '$2a$10$vAKg7q1eGsBRwnUp4VotqeEaZr8e7mnzoz5oEla7WgKuGNM8aQgHS', 1, @admin);
call createUserHasRole(@admin, @role_admin);

call createUser('supervisor', '$2a$10$YrFJXGa6aGCNm54Nll9fZuzWc05ODVuIH3Vvk0VfyzPILigbWueP2', 1, @supervisor);
call createUserHasRole(@supervisor, @role_supervisor);

call createUser('leader', '$2a$10$cQeiO1XmbSwBZUa5NA/8F.8iUzs4Ow4WmSJ9Hyfa2QvTKsm6y3zfy', 1, @leader);
call createUserHasRole(@leader, @role_leader);

call createUser('user', '$2a$10$qiNk/KU3HnqMecOHsqfMHOLWXoaDnRcnnzUGYR/d53nK6FHZmYici', 1, @user);
call createUserHasRole(@user, @role_user);