CREATE TABLE product
(
    id          INT AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
    name       VARCHAR(100) NOT NULL COMMENT '제품명',
    content     TEXT COMMENT '제품 설명',
    price     INT COMMENT '제품 가격',
    category_id INT COMMENT '카테고리 id',
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '수정일시',
    deleted_at  TIMESTAMP COMMENT '삭제일시(미삭제 시 NULL)'
);

commit;