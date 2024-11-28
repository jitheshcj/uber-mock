INSERT INTO app_user(name, email, password) VALUES
('Ishaan Verma', 'ishaan.verma@gmail.com', 'pass123'),
('Diya Patel', 'diya.patel@gmail.com', 'mypassword'),
('Ayaan Gupta', 'ayaan.gupta@gmail.com', 'ayaan@123'),
('Meera Rao', 'meera.rao@gmail.com', 'meera456'),
('Kabir Singh', 'kabir.singh@gmail.com', 'kabirPass'),
('Sara Khan', 'sara.khan@gmail.com', 'sara789'),
('Rohan Joshi', 'rohan.joshi@gmail.com', 'rohan2024'),
('Anika Roy', 'anika.roy@gmail.com', 'anika@secure'),
('Vihaan Das', 'vihaan.das@gmail.com', 'vihaan789'),
('Nisha Nair', 'nisha.nair@gmail.com', 'nisha123'),
('Aryan Menon', 'aryan.menon@gmail.com', 'aryan@pass'),
('Kiara Desai', 'kiara.desai@gmail.com', 'kiara2024'),
('Advait Kulkarni', 'advait.kulkarni@gmail.com', 'advait123'),
('Riya Sharma', 'riya.sharma@gmail.com', 'riya456'),
('Vivaan Iyer', 'vivaan.iyer@gmail.com', 'vivaan@pass'),
('Anushka Bhatia', 'anushka.bhatia@gmail.com', 'anushka789'),
('Arjun Mishra', 'arjun.mishra@gmail.com', 'arjun2024'),
('Nitya Jain', 'nitya.jain@gmail.com', 'nitya@pass'),
('Karan Kapoor', 'karan.kapoor@gmail.com', 'karan123'),
('Tara Dutta', 'tara.dutta@gmail.com', 'tara456'),
('Aditya Sengupta', 'aditya.sengupta@gmail.com', 'aditya@789');

INSERT INTO user_roles(user_id, roles) VALUES
(1, 'RIDER'),
(2, 'DRIVER'),
(3, 'RIDER'),
(4, 'DRIVER'),
(5, 'RIDER'),
(6, 'DRIVER'),
(7, 'RIDER'),
(8, 'DRIVER'),
(9, 'RIDER'),
(10, 'DRIVER'),
(11, 'RIDER'),
(12, 'DRIVER'),
(13, 'RIDER'),
(14, 'DRIVER'),
(15, 'RIDER'),
(16, 'DRIVER'),
(17, 'RIDER'),
(18, 'DRIVER'),
(19, 'RIDER'),
(20, 'DRIVER');

INSERT INTO rider (id, user_id, rating) VALUES
(1, 1, 4.9),
(2, 2, 4.8),
(3, 3, 4.7),
(4, 4, 4.6);


INSERT INTO driver (user_id, rating, available, vehicle_id, current_location) VALUES
(5, 4.5, TRUE, 'VEH001', ST_PointFromText('POINT(77.5946 12.9716)', 4326)),
(6, 4.6, FALSE, 'VEH002', ST_PointFromText('POINT(72.8777 19.0760)', 4326)),
(7, 4.8, TRUE, 'VEH003', ST_PointFromText('POINT(88.3639 22.5726)', 4326)),
(8, 4.7, TRUE, 'VEH004', ST_PointFromText('POINT(78.9629 20.5937)', 4326)),
(9, 4.4, FALSE, 'VEH005', ST_PointFromText('POINT(80.2707 13.0827)', 4326)),
(10, 4.9, TRUE, 'VEH006', ST_PointFromText('POINT(77.2090 28.6139)', 4326)),
(11, 4.3, TRUE, 'VEH007', ST_PointFromText('POINT(75.8577 26.9124)', 4326)),
(12, 4.5, FALSE, 'VEH008', ST_PointFromText('POINT(76.2999 9.9312)', 4326));