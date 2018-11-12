# DROP TABLE IF EXISTS wx_users;
# DROP TABLE IF EXISTS customers;
# DROP TABLE IF EXISTS address;
# DROP TABLE IF EXISTS dishes;
# DROP TABLE IF EXISTS cates;
# DROP TABLE IF EXISTS order_details;
# DROP TABLE IF EXISTS shop_marked;
# DROP TABLE IF EXISTS orders;
# DROP TABLE IF EXISTS comments;
# DROP TABLE IF EXISTS shops;
# DROP TABLE IF EXISTS config;
# DROP TABLE IF EXISTS users;

CREATE TABLE wx_users (
  id INT (10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  wxid VARCHAR (30)
);
CREATE UNIQUE INDEX idx_wxid ON wx_users(wxid(30));

CREATE TABLE users (
  id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  tel VARCHAR(15) UNIQUE,
  password VARCHAR(100),
  role TINYINT(3) UNSIGNED,
  created_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NULL
);

CREATE TRIGGER `update_users_trigger` BEFORE UPDATE ON `users`
FOR EACH ROW SET NEW.`updated_at` = NOW();

CREATE TABLE customers (
  id INT(10) UNSIGNED NOT NULL PRIMARY KEY,
  name VARCHAR(10) NULL,
  gender TINYINT(3),
  sid VARCHAR(30) NULL,
  img VARCHAR(255) NULL,
  created_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NULL
);
CREATE INDEX idx_customer_name ON customers(name(10));
CREATE TRIGGER `update_customer_trigger` BEFORE UPDATE ON `customers`
  FOR EACH ROW SET NEW.`updated_at` = NOW();

CREATE TABLE address (
  id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_id INT(10) UNSIGNED NOT NULL,
  tel VARCHAR(15) NULL,
  name VARCHAR(50) NULL,
  description VARCHAR(255) NULL,
  created_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NULL ,

  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
CREATE TRIGGER `update_address_trigger` BEFORE UPDATE ON `address`
  FOR EACH ROW SET NEW.`updated_at` = NOW();

CREATE TABLE shops (
  id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_id INT(10) UNSIGNED NOT NULL,
  name VARCHAR(30),
  img VARCHAR(255) NULL,
  status TINYINT(3) UNSIGNED default 0,
  address VARCHAR(255),
  created_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NULL ,

  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
CREATE INDEX idx_shop_name ON shops(name(30));
CREATE TRIGGER `update_shops_trigger` BEFORE UPDATE ON `shops`
  FOR EACH ROW SET NEW.`updated_at` = NOW();

CREATE TABLE cates (
  id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  shop_id INT(10) UNSIGNED NOT NUll,
  name VARCHAR(30),
  FOREIGN KEY (shop_id) REFERENCES shops(id)
);

CREATE TABLE dishes (
  id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(30),
  description VARCHAR(255) NULL,
  cate_id INT(10) UNSIGNED,
  img VARCHAR(255) NULL,
  status TINYINT(3) unsigned DEFAULT 0,
  provider INT(10) UNSIGNED NOT NULL,
  price INT(10) UNSIGNED,
  created_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NULL ,

  FOREIGN KEY (cate_id) REFERENCES cates(id) ON DELETE NO ACTION,
  FOREIGN KEY (provider) REFERENCES shops(id) on DELETE NO ACTION
);
CREATE INDEX idx_dishes_name ON dishes(name(30));
CREATE TRIGGER `update_dishes_trigger` BEFORE UPDATE ON `dishes`
  FOR EACH ROW SET NEW.`updated_at` = NOW();

CREATE TABLE orders (
  id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  code VARCHAR(30),
  price INT(10) UNSIGNED,
  user_id INT(10) UNSIGNED NOT NULL,
  ip VARCHAR(45),
  address VARCHAR(255),
  provider INT(10) UNSIGNED NOT NULL,
  status TINYINT(3) UNSIGNED DEFAULT 0,
  delivery_date VARCHAR(30),
  delivery_time VARCHAR(30),
  remark VARCHAR(255) NULL,
  created_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NULL ,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE NO ACTION,
  FOREIGN KEY (provider) REFERENCES shops(id) ON DELETE NO ACTION
);
# 通过订单号去数据库中查询，判断该订单是否已经存在
CREATE UNIQUE INDEX idx_order_code ON orders(code(30));
# 优先处理录入时间长的订单
CREATE INDEX idx_created_time ON orders(created_at);
CREATE TRIGGER `update_orders_trigger` BEFORE UPDATE ON `orders`
  FOR EACH ROW SET NEW.`updated_at` = NOW();

CREATE TABLE order_details (
  order_id INT(10) UNSIGNED NOT NULL,
  item_id INT(10) UNSIGNED NOT NULL,
  num INT(10) UNSIGNED,
  price INT(10) UNSIGNED,
  PRIMARY KEY (order_id, item_id),
  FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
  FOREIGN KEY (item_id) REFERENCES dishes(id) ON DELETE NO ACTION
);

CREATE TABLE comments (
  id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  score TINYINT(3) UNSIGNED,
  type TINYINT(3) UNSIGNED,
  content VARCHAR(255) NULL,
  user_id INT(10) UNSIGNED NOT NULL,
  shop_id INT(10) UNSIGNED NOT NULL,
  reply VARCHAR(512) NULL,
  created_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NULL ,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
  FOREIGN KEY (shop_id) REFERENCES shops(id) ON DELETE CASCADE
);
CREATE TRIGGER `update_comments_trigger` BEFORE UPDATE ON `comments`
  FOR EACH ROW SET NEW.`updated_at` = NOW();

CREATE TABLE config (
  `key` VARCHAR(127),
  `value` VARCHAR(127)
);

CREATE TABLE shop_marked (
  user_id INT(10) UNSIGNED NOT NULL,
  shop_id INT(10) UNSIGNED NOT NULL,
  status BOOLEAN,
  created_at TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NULL ,
  PRIMARY KEY (user_id, shop_id),
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
  FOREIGN KEY (shop_id) REFERENCES shops(id) ON DELETE CASCADE
);
CREATE TRIGGER `update_shop_marked_trigger` BEFORE UPDATE ON `shop_marked`
  FOR EACH ROW SET NEW.`updated_at` = NOW();
