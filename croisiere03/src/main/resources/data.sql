-- données pour croisière01 --

INSERT INTO `client` (`id`, `nom`, `prenom`) VALUES
(1, 'Louis', 'Laetitia'),
(2, 'Fournol', 'Didier'),
(3, 'Balcon', 'Sophie'),
(4, 'Deride', 'Tony'),
(5, 'Congard', 'Nicolas');

INSERT INTO `paquebot` (`id`, `nom`, `tonnage`) VALUES
(1, 'British Queen', 1860),
(2, 'Titanic', 46328),
(3, 'Oasis of the Seas', 225282);

INSERT INTO `croisiere` (`id`, `duree`, `nom`, `paquebot_id`) VALUES
(1, 15, 'Mer Egée', 1),
(2, 9, 'Mer Caspied', 1),
(3, 12, 'Adriatique', 3);

INSERT INTO `reservation` (`id`, `date_resa`, `montant`, `croisiere_id`) VALUES
(1, '2020-11-12', 2400, 3),
(2, '2020-01-23', 11500, 3),
(3, '2020-03-04', 1199, 3),
(4, '2020-04-12', 2867, 3),
(5, '2020-02-22', 890, 3),
(6, '2020-02-27', 2543, 3),
(7, '2020-12-22', 2400, 2),
(8, '2020-02-27', 1199, 2),
(9, '2020-02-22', 1199, 2);

INSERT INTO `reservation_client` (`reservation_id`, `client_id`) VALUES
(1, 1),
(2, 1),
(4, 1),
(6, 1),
(8, 1),
(9, 1),
(1, 2),
(2, 2),
(4, 2),
(6, 2),
(8, 2),
(9, 2),
(1, 3),
(2, 3),
(4, 3),
(6, 3),
(8, 3),
(9, 3),
(3, 4),
(5, 4),
(7, 4),
(3, 5),
(5, 5),
(7, 5);
