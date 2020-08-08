
    insert into person(id, name, pid, gender)
    values (1, 'Le Van A', null, 0),
           (2, 'Nguyen Thi A', null, 1),
           (3, 'Nguyen Thi B', null, 1),
           (4, 'Nguyen Thi C', null, 1);
    insert into marriage(pid, descendant_id, spouse_id, index)
    values (1, 1, 2, 1),
           (2, 1, 3, 2),
           (3, 1, 4, 3);
    insert into person(id, name, pid, gender)
    values (5, 'Le Tran B', 1, 0),
           (6, 'Nguyen Hoa D', null, 1),
           (7, 'Le Huyen E', 1, 1),
           (8, 'Le Huyen F', 3, 1);
    insert into marriage(pid, descendant_id, spouse_id, index)
    values (4, 5, 6, 1);
    insert into person(id, name, pid, gender)
    values (9, 'Le Bao C', 4, 1);

