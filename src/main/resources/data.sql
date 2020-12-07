insert into ltw.car(brandname, platenumber, color, model, seatnumber, usedyear, lastmaintaincedate) values
	('Toyota', 'ABC23424', 'black', 'Flat', 100, 1, '2020-11-07'),
	('Vinfast', 'ABC23424', 'black', 'President', 100, 1, '2020-11-07'),
	('Audi', 'ABC23424', 'black', 'Flat', 100, 1, '2020-11-07');
insert into ltw.employee(cmt, diachi, loaibl, name, ngaysinh, thamnien) values
	('001099009981', 'Van Tu', 'B1', 'Le Van Sang', '29-12-1999', 4),
    ('001099009982', 'Van Tu', 'B1', 'Le Van Sa', '29-12-1999', 4);
insert into ltw.route(complicatedlevel, end, length, start) values
	(1,'Giap Bat',20,'Cau Gie'),
    (2,'Giap Bat',30,'Bat Giap'),
    (3,'Giap Bat',40,'Ha Tay'),
    (3,'Giap Bat',40,'Thuong Tin');
insert into ltw.trip(numberofpassengers, createdat, price, car_id, driver_id, subdriver_id, route_id) values 
(98, '2020-11-27', 7000.0, 1, 1, 2, 1), 
(98, '2020-11-27', 7000.0, 2, 3, 2, 2), 
(98, '2020-11-27', 7000.0, 3, 25, 2, 3), 
(98, '2020-11-27', 7000.0, 1, 3, 1, 2), 
(98, '2020-11-27', 7000.0, 2, 5, 1, 3);