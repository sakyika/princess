delimiter //
DROP PROCEDURE IF EXISTS createPatientPermission;
DROP PROCEDURE IF EXISTS createPatientRole;
DROP PROCEDURE IF EXISTS createPatientRoleHasPatientPermission;
DROP PROCEDURE IF EXISTS createPatientUser;
DROP PROCEDURE IF EXISTS createPatientUserHasPatientRole;

create procedure createPatientPermission($permissionName varchar(50))
begin
	insert into permissions (permissionName) values ($permissionName);
end	//

create procedure createPatientRole($roleName varchar(50), out $id int)
begin
	insert into roles (rolename) values ($roleName);
end //

create procedure createPatientRoleHasPatientPermission($roleId int, $permissionName varchar(50))
begin
	declare _permissionId int;
	select id from permissions where permissionname = $permissionName into _permissionId;
	insert into role_permissions (role_id, permission_id) values($roleId, $permissionName);
end //

create procedure createPatientUser($username varchar(50), $password varchar(100), $enable tinyint(1), out $id int)
begin
	insert into users (username, password, enabled) values ($username, $password, $enable);
	set $id := last_insert_id();
end	//

create procedure createPatientUserHasPatientRole($userId int, $roleId int)
begin
	insert into user_roles (user_id, role_id) values ($userId, $roleId);
end //

delimiter ;





