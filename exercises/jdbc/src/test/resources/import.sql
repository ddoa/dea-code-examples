CREATE TABLE IF NOT EXISTS `items` (
  `id`       INT(11) NOT NULL,
  `category` VARCHAR(255) DEFAULT NULL,
  `sku`      VARCHAR(255) DEFAULT NULL,
  `title`    VARCHAR(255) DEFAULT NULL
);

INSERT INTO `items` (`id`, `category`, `sku`, `title`) VALUES (1, 'Snacks', 'Bamibal', 'Ook vegetarisch verkrijgbaar');