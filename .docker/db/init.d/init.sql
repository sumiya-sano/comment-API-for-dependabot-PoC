use MoriSano;

DROP TABLE IF EXISTS users;

DROP TABLE IF EXISTS comments;

CREATE TABLE
    users (
        user_id VARCHAR(12) NOT NULL PRIMARY KEY,
        user_name VARCHAR(40) NOT NULL
    );

CREATE TABLE
    comments (
        comment_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        user_id VARCHAR(12) NOT NULL,
        movie_id VARCHAR(12) NOT NULL,
        comment_body VARCHAR(120) NOT NULL,
        update_date DATETIME default current_timestamp on update current_timestamp
    );

INSERT INTO
    users
values
    ("001", "Mori Yamato");

INSERT INTO
    users
values
    ("002", "Sano Sumiya");

INSERT INTO
    users
values
    ("003", "John Doe");

INSERT INTO
    users
values
    ("004", "Yamamoto Shin");

INSERT INTO
    comments (user_id, movie_id, comment_body, update_date)
values
    ("001", "3258", "面白いとは思っている", "2024/06/04");

INSERT INTO
    comments (user_id, movie_id, comment_body, update_date)
values
    ("002", "3258", "俺はあんまり好きではない", "2024/06/04");

INSERT INTO
    comments (user_id, movie_id, comment_body, update_date)
values
    ("003", "3258", "うどん食べたい", "2024/06/04");

INSERT INTO
    comments (user_id, movie_id, comment_body, update_date)
values
    (
        "004",
        "3258",
        "今日の天気は雨だから、映画を見れて結構面白かった。次は映画館で観たい",
        "2024/06/04"
    );