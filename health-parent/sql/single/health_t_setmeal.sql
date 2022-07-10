create table t_setmeal
(
    id        int auto_increment
        primary key,
    name      varchar(128) null,
    code      varchar(8)   null,
    helpCode  varchar(16)  null,
    sex       char         null,
    age       varchar(32)  null,
    price     float        null,
    remark    varchar(128) null,
    attention varchar(128) null,
    img       varchar(128) null
);

INSERT INTO health.t_setmeal (id, name, code, helpCode, sex, age, price, remark, attention, img) VALUES (19, '入职无忧体检套餐（男女通用）', '0001', 'RZTJ', '0', '18-60', 300, '入职体检套餐', null, '596420cd-96da-4b6b-b946-fba3cfe983cd1.jpg');
INSERT INTO health.t_setmeal (id, name, code, helpCode, sex, age, price, remark, attention, img) VALUES (20, '粉红珍爱(女)升级TM12项筛查体检套餐', '0002', 'FHZA', '2', '18-60', 1200, '本套餐针对宫颈(TCT检查、HPV乳头瘤病毒筛查）、乳腺（彩超，癌抗125），甲状腺（彩超，甲功验血）以及胸片，血常规肝功等有全面检查，非常适合女性全面疾病筛查使用。', null, '90f3f5b5-1aab-4731-9514-4c384ee30bac2.jpg');
INSERT INTO health.t_setmeal (id, name, code, helpCode, sex, age, price, remark, attention, img) VALUES (21, '阳光爸妈升级肿瘤12项筛查（男女单人）体检套餐', '0003', 'YGBM', '0', '50-100', 1500, '本套餐主要针对常见肿瘤筛查，肝肾、颈动脉、脑血栓、颅内血流筛查，以及风湿、颈椎、骨密度检查', null, '6f4b91cf-c2b5-427f-b6be-1f1dbfc533773.jpg');
INSERT INTO health.t_setmeal (id, name, code, helpCode, sex, age, price, remark, attention, img) VALUES (22, '珍爱高端升级肿瘤12项筛查（男女单人）', '0004', 'ZAGD', '0', '14-20', 2400, '本套餐是一款针对生化五项检查，心，肝，胆，胃，甲状腺，颈椎，肺功能，脑部检查（经颅多普勒）以及癌症筛查，适合大众人群体检的套餐', null, '00ad09cd-1650-4f70-94cf-6e1fbf2168a92.jpg');
INSERT INTO health.t_setmeal (id, name, code, helpCode, sex, age, price, remark, attention, img) VALUES (23, '测试', '0005', 'CS', '0', '10-20', 100, '测试数据', '测试数据', '46f8c4af-49ac-4edc-9e3b-18a4dad0ea151.jpg');