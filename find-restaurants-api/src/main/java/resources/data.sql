INSERT INTO `restaurant`.`restaurant` (`id`, `name`, `type`, `imageurl`, `phone`, `website`) VALUES ('1000', 'KFC', 'Non Veg', 'https://en.wikipedia.org/wiki/File:KFC_logo.svg', '987654321', 'https://online.kfc.co.in');
INSERT INTO `restaurant`.`restaurant` (`id`, `name`, `type`, `imageurl`, `phone`, `website`) VALUES ('1001', 'Domino's', 'Non Veg', 'https://www.eweek.com/imagesvr_ez/b2bezp/2018/01/Dominos.pizza.JPG?alias=article_hero', '987654321', 'https://pizzaonline.dominos.co.in');

INSERT INTO `restaurant`.`address` (`id`, `latitude`, `longitude`, `restaurant_id`) VALUES ('10000', '12.971112', '80.188533', '1000');
INSERT INTO `restaurant`.`address` (`id`, `latitude`, `longitude`, `restaurant_id`) VALUES ('10001', '12.993253', '80.216244', '1000');
