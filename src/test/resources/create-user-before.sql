delete from user_role;
delete from usr;

insert into usr(id, active, password, username) values
                                                    (1, true, '"$2a$10$KxfKwK64Wh0jQnS.yg16fuhWRuZgPdPMs4zZJr8DTqFjU1AYPTuFi"', 'savik'),
                                                    (2, true, '"$2a$10$KxfKwK64Wh0jQnS.yg16fuhWRuZgPdPMs4zZJr8DTqFjU1AYPTuFi"', 'user');

insert into user_role(user_id, roles) values
                                          (1, 'USER'), (1, 'ADMIN'),
                                          (2, 'USER');