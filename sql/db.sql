CREATE TABLE post
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    title      VARCHAR(100) NOT NULL,
    content    TEXT,
    image_url  VARCHAR(255),
    likes      INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);