-- ================================= 지역코드 마스터 (17개 시도) =================================
INSERT INTO region_code (region_id, region_name, nx, ny, kosis_block_index) VALUES (1, '서울', 60, 127, 0);
INSERT INTO region_code (region_id, region_name, nx, ny, kosis_block_index) VALUES (2, '부산', 98, 76, 1);
INSERT INTO region_code (region_id, region_name, nx, ny, kosis_block_index) VALUES (3, '대구', 89, 90, 2);
INSERT INTO region_code (region_id, region_name, nx, ny, kosis_block_index) VALUES (4, '인천', 55, 124, 3);
INSERT INTO region_code (region_id, region_name, nx, ny, kosis_block_index) VALUES (5, '광주', 58, 74, 4);
INSERT INTO region_code (region_id, region_name, nx, ny, kosis_block_index) VALUES (6, '대전', 67, 100, 5);
INSERT INTO region_code (region_id, region_name, nx, ny, kosis_block_index) VALUES (7, '울산', 102, 84, 6);
INSERT INTO region_code (region_id, region_name, nx, ny, kosis_block_index) VALUES (8, '세종', 66, 103, 7);
INSERT INTO region_code (region_id, region_name, nx, ny, kosis_block_index) VALUES (9, '경기', 60, 120, 8);
INSERT INTO region_code (region_id, region_name, nx, ny, kosis_block_index) VALUES (10, '강원', 73, 134, 9);
INSERT INTO region_code (region_id, region_name, nx, ny, kosis_block_index) VALUES (11, '충북', 69, 107, 10);
INSERT INTO region_code (region_id, region_name, nx, ny, kosis_block_index) VALUES (12, '충남', 68, 100, 11);
INSERT INTO region_code (region_id, region_name, nx, ny, kosis_block_index) VALUES (13, '전북', 63, 89, 12);
INSERT INTO region_code (region_id, region_name, nx, ny, kosis_block_index) VALUES (14, '전남', 51, 67, 13);
INSERT INTO region_code (region_id, region_name, nx, ny, kosis_block_index) VALUES (15, '경북', 89, 91, 14);
INSERT INTO region_code (region_id, region_name, nx, ny, kosis_block_index) VALUES (16, '경남', 91, 77, 15);
INSERT INTO region_code (region_id, region_name, nx, ny, kosis_block_index) VALUES (17, '제주', 52, 38, 16);

-- ================================= 기업 샘플 데이터 (실제 기업 정보) =================================
INSERT INTO company (company_id, company_name, business_number, ceo_name, start_date, address, business_license, create_date, update_date)
VALUES
(1,  '삼성전자',       '124-81-00998', '이재용',  '19690113', '경기도 수원시 영통구 삼성로 129', null, now(), now()),
(2,  '카카오',         '120-81-47521', '정신아',  '20060203', '제주특별자치도 제주시 첨단로 242', null, now(), now()),
(3,  '네이버',         '220-81-62517', '최수연',  '19990602', '경기도 성남시 분당구 불정로 6', null, now(), now()),
(4,  'LG전자',         '107-86-14075', '조주완',  '19580101', '서울특별시 영등포구 여의대로 128', null, now(), now()),
(5,  'SK하이닉스',     '129-81-09558', '곽노정',  '19830201', '경기도 이천시 부발읍 이천대로 2091', null, now(), now()),
(6,  '현대자동차',     '107-81-18268', '장재훈',  '19670329', '서울특별시 서초구 헌릉로 12', null, now(), now()),
(7,  '기아',           '106-81-16643', '송호성',  '19440609', '서울특별시 서초구 헌릉로 12', null, now(), now()),
(8,  'SK텔레콤',       '220-81-00264', '유영상',  '19840303', '서울특별시 중구 을지로 65', null, now(), now()),
(9,  'KT',             '502-81-13601', '김영섭',  '19810101', '경기도 성남시 분당구 불정로 90', null, now(), now()),
(10, 'LG유플러스',     '032-86-07750', '황현식',  '19960401', '서울특별시 용산구 한강대로 32', null, now(), now()),
(11, '포스코',         '107-81-18366', '장인화',  '19680401', '서울특별시 강남구 테헤란로 440', null, now(), now()),
(12, 'KB국민은행',     '408-81-39950', '이재근',  '19631001', '서울특별시 영등포구 국제금융로 8', null, now(), now()),
(13, '신한은행',       '100-81-02535', '정상혁',  '19820701', '서울특별시 중구 세종대로 9', null, now(), now()),
(14, '하나은행',       '138-81-00220', '이승열',  '19710201', '서울특별시 중구 을지로 66', null, now(), now()),
(15, '우리은행',       '202-81-00197', '조병규',  '19991227', '서울특별시 중구 소공로 51', null, now(), now()),
(16, '롯데케미칼',     '107-81-18672', '신동빈',  '19760201', '서울특별시 영등포구 여의대로 128', null, now(), now()),
(17, 'CJ제일제당',     '110-81-02149', '최은석',  '19530101', '서울특별시 중구 동호로 330', null, now(), now()),
(18, '두산에너빌리티', '113-81-00202', '박지원',  '19621001', '경상남도 창원시 성산구 두산볼보로 22', null, now(), now()),
(19, 'HD현대',         '120-81-00260', '정기선',  '20021001', '경기도 성남시 분당구 판교로 344', null, now(), now()),
(20, 'GS칼텍스',       '130-81-05064', '허세홍',  '19670101', '서울특별시 강남구 논현로 508', null, now(), now());

-- ================================= 회원테이블 샘플 코드 (BCrypt 적용) =================================
-- 비밀번호는 BCrypt로 암호화됨. 원본 비밀번호는 아래 주석 참고
-- ================================= 회원 샘플 로그인 정보 =================================
-- member_id | mname             | password
-- 1         | tech_vision_01    | vsn!2024#
-- 2         | blue_ocean_intl   | ocean7788*
-- 3         | green_farm_korea  | farm9900!
-- 4         | smart_logic_lab   | logic1234@
-- 5         | global_logis_sys  | logis_best
-- 6         | future_mob_dev    | f_mobility!
-- 7         | creative_ads_kr   | ads_master1
-- 8         | health_care_plus  | hp_9988#
-- 9         | urban_design_st   | urban_it_00
-- 10        | mega_store_dist   | mega_pass!
-- 11        | cloud_infra_sol   | cld!9900#
-- 12        | neo_medical_kr    | neo_med_24
-- 13        | atlas_heavy_ind   | atlas_pwr!
-- 14        | vision_it_group   | v_it_2026*
-- 15        | k_logistics_net   | k_logis_pass
-- 16        | urban_re_mgt      | urban_mgt_1
-- 17        | eco_power_tech    | eco_tech_!@
-- 18        | global_edu_plus   | edu_p_7788
-- 19        | smart_iot_lab     | iot_lab_001
-- 20        | prime_food_sys    | prime_f_365

INSERT INTO member (member_id, company_id, member_name, password, party_name, company_number, email, address, create_date, update_date)
VALUES
(1, 4, 'tech_vision_01', '$2b$12$f8tJbai9YbFKqWWpYWoNRuZ5uamT.AsjSHp3LHvQsv22ydxDhzx4m', '김도윤', '010-2938-1029', 'dy.kim@techvision.co.kr', '서울특별시 강남구 테헤란로 427', now(), now()),
(2, 1, 'blue_ocean_intl', '$2b$12$O9WT/AW9ooIy8Jj72XQ4Tu/bZG6wjdeM5VNtxGmvtnxlR.TluOyba', '이현우', '010-8821-3304', 'hwlee@blueocean.com', '경기도 성남시 분당구 판교역로 166', now(), now()),
(3, 9, 'green_farm_korea', '$2b$12$PF4Fps0hjrM5tvCKpcOZduwfyff57Z409jrWcHIJsYzfLiohpW1su', '박서준', '010-4456-7812', 'seo_jun@greenfarm.kr', '전라남도 나주시 빛가람로 350', now(), now()),
(4, 8, 'smart_logic_lab', '$2b$12$oD9n6kltZn7o1jx42UTMV.tW39iCAfbLZYD55zojMmKjQcR3530G.', '최하은', '010-5567-1123', 'haeun.choi@smartlogic.io', '서울특별시 구로구 디지털로 300', now(), now()),
(5, 8, 'global_logis_sys', '$2b$12$GjE1DXPbN0Rewnw48kAMUeVHi8dqbs.DwLUGXljO49CO9S4atSQ9e', '정민호', '010-9901-2234', 'mh.jung@globallogis.net', '부산광역시 강서구 유통단지로 23', now(), now()),
(6, 5, 'future_mob_dev', '$2b$12$2wyWMuTCcev4F8vK2eXWWeOH15bWdG5G7heAI0P94o84oMsHwyqnO', '강지안', '010-3345-6678', 'jian.kang@futuremob.co.kr', '경기도 화성시 삼성로 1', now(), now()),
(7, 4, 'creative_ads_kr', '$2b$12$/Fm2MH/0m72OWcawU99xYO0wkIL1E/3hfygLbH9UF1zRUHHoNoJcy', '윤소희', '010-7788-9901', 'sh.yoon@creativeads.com', '서울특별시 마포구 양화로 144', now(), now()),
(8, 18, 'health_care_plus', '$2b$12$3CVA8FiSqXsK1tctusmVB.MNT1mFQZP/pUztkdS/BEJwiKSelpjIm', '한준영', '010-2211-4433', 'jy.han@healthcareplus.kr', '대구광역시 중구 달구벌대로 2077', now(), now()),
(9, 3, 'urban_design_st', '$2b$12$nyQ/DHK3oxcxlcZqp9Hh0Os7i0/CHn.V8p9X/w7w89AFXKoV2eOrm', '송미경', '010-6655-1100', 'mk.song@urbandesign.co.kr', '서울특별시 성동구 성수이로 113', now(), now()),
(10, 19, 'mega_store_dist', '$2b$12$WHmlmkL1Q/DpRDpkpJGnNOTI1zfqV6SL2hvlNmioL4kD1Cx2dUxt2', '임재상', '010-4499-8822', 'js.lim@megastore.co.kr', '인천광역시 부평구 부평대로 20', now(), now()),
(11, 14, 'cloud_infra_sol', '$2b$12$jK.Lt0/ccdbhvPe3yo.7U.vEZ3kjf4NnpymKRYEraPTzTWA7TH95O', '박준영', '010-3388-1122', 'jy.park@cloudinfra.co.kr', '서울특별시 서초구 서초대로 301', now(), now()),
(12, 2, 'neo_medical_kr', '$2b$12$9S0KE7OZEK1VXU8JDiHhqetKid9ALxbMIUu5xa/vE7CD5I.DBuHlO', '이서연', '010-7744-8899', 'sy.lee@neomed.kr', '경기도 수원시 영통구 광교중앙로', now(), now()),
(13, 1, 'atlas_heavy_ind', '$2b$12$aYk4tkfH7VYB6pXDUsh8qeqOLU63LdAH8vSKeQiPzzukbl6f29Kp6', '최동현', '010-2211-5544', 'dh.choi@atlasind.com', '울산광역시 동구 방어진순환도로', now(), now()),
(14, 3, 'vision_it_group', '$2b$12$pfRbPDBsoQoHvmkP4n0aAu0q7McZhStUQt2likCj0YGES0iUMomVa', '김민지', '010-4455-2233', 'mj.kim@visionit.io', '서울특별시 금천구 가산디지털1로', now(), now()),
(15, 7, 'k_logistics_net', '$2b$12$7dN/O6tBHe4zm2aOBR412uw51uTKhP/aDqQ/jy5.gU0UAMByOK3fa', '정태우', '010-9988-7766', 'tw.jung@klogis.net', '인천광역시 중구 공항동로 295', now(), now()),
(16, 8, 'urban_re_mgt', '$2b$12$2fNrxcVvgmgeILczuTJfM.Dp9uBkoexJeQCD.JywQdrt9Fl3v4oFK', '황수진', '010-1133-4422', 'sj.hwang@urbanmgt.co.kr', '서울특별시 종로구 율곡로 6', now(), now()),
(17, 17, 'eco_power_tech', '$2b$12$JYQLo0cN1xdtlXTq736bse2rl8gXq593rqXswr83RYPrZnT6v.5Bu', '안재현', '010-5566-3311', 'jh.ahn@ecopower.kr', '전라남도 나주시 전력로 11', now(), now()),
(18, 20, 'global_edu_plus', '$2b$12$.yYKJ6N8iAiXQubn2sSdseeCyEF7auTFosFkCtwGhWLn/PoAvgjHW', '윤하은', '010-8811-9922', 'he.yoon@eduplus.com', '서울특별시 강남구 역삼로 415', now(), now()),
(19, 1, 'smart_iot_lab', '$2b$12$78ZIBwoR9EjnReyCbHS/Fu9Z2Yn4EU2GfJgLvJRAqqHU8S2NrVG7y', '박성민', '010-2244-6688', 'sm.park@smartiot.io', '경기도 성남시 수정구 창업로 40', now(), now()),
(20, 18, 'prime_food_sys', '$2b$12$zIaarbB2t4z0q9myCXGqqu6YC.n/ZDhz97S1nBzDIw/980d.ABnRy', '강도윤', '010-7799-1155', 'dy.kang@primefood.co.kr', '충청북도 음성군 원남면 원남산단로', now(), now());


-- ================================= 전문가테이블 샘플 코드  =================================
INSERT INTO expert (expert_id, expert_name, company_number, expert_email, expert_date, expert_state, create_date)
VALUES (1, '김민준', '010-1234-5678', 'minjun.kim@arbo.co.kr', now(), '활동중', now()),
       (2, '이서연', '010-2345-6789', 'seoyeon.lee@greentech.kr', now(), '활동중', now()),
       (3, '박지훈', '010-3456-7890', 'jihoon.park@forest.go.kr', now(), '활동중', now()),
       (4, '최수아', '010-4567-8901', 'sua.choi@treeclinic.kr', now(), '휴직', now()),
       (5, '정우진', '010-5678-9012', 'woojin.jung@eco.co.kr', now(), '활동중', now()),
       (6, '강하은', '010-6789-0123', 'haeun.kang@arborist.kr', now(), '활동중', now()),
       (7, '조현우', '010-7890-1234', 'hyunwoo.jo@greenforest.kr', now(), '퇴직', now()),
       (8, '윤지아', '010-8901-2345', 'jia.yoon@treeman.co.kr', now(), '활동중', now()),
       (9, '임도현', '010-9012-3456', 'dohyun.lim@eco.go.kr', now(), '활동중', now()),
       (10, '한소희', '010-0123-4567', 'sohee.han@forest.co.kr', now(), '휴직', now()),
       (11, '오승준', '010-1111-2222', 'seungjun.oh@arbo.kr', now(), '활동중', now()),
       (12, '신예린', '010-2222-3333', 'yerin.shin@greenlab.kr', now(), '활동중', now()),
       (13, '권태양', '010-3333-4444', 'taeyang.kwon@treecare.kr', now(), '활동중', now()),
       (14, '남지원', '010-4444-5555', 'jiwon.nam@eco.co.kr', now(), '퇴직', now()),
       (15, '황민서', '010-5555-6666', 'minseo.hwang@forest.go.kr', now(), '활동중', now()),
       (16, '유준혁', '010-6666-7777', 'junhyuk.yu@arborist.co.kr', now(), '활동중', now()),
       (17, '배나연', '010-7777-8888', 'nayeon.bae@greentech.kr', now(), '휴직', now()),
       (18, '서동현', '010-8888-9999', 'donghyun.seo@treeman.kr', now(), '활동중', now()),
       (19, '문채원', '010-9999-0000', 'chaewon.moon@eco.go.kr', now(), '활동중', now()),
       (20, '류지성', '010-1357-2468', 'jisung.ryu@forest.co.kr', now(), '활동중', now()),
       (21, '노은서', '010-2468-1357', 'eunseo.no@arbo.co.kr', now(), '퇴직', now()),
       (22, '홍준서', '010-1122-3344', 'junseo.hong@greenlab.kr', now(), '활동중', now()),
       (23, '전소율', '010-3344-5566', 'soyul.jeon@treecare.co.kr', now(), '활동중', now()),
       (24, '송민재', '010-5566-7788', 'minjae.song@eco.kr', now(), '휴직', now()),
       (25, '안지후', '010-7788-9900', 'jihoo.ahn@forest.go.kr', now(), '활동중', now()),
       (26, '김태리', '010-9900-1122', 'taeri.kim@arborist.kr', now(), '활동중', now()),
       (27, '이현진', '010-1212-3434', 'hyunjin.lee@greentech.co.kr', now(), '활동중', now()),
       (28, '박수현', '010-3434-5656', 'suhyun.park@treeman.kr', now(), '퇴직', now()),
       (29, '최지민', '010-5656-7878', 'jimin.choi@eco.co.kr', now(), '활동중', now()),
       (30, '정하준', '010-7878-9090', 'hajun.jung@forest.kr', now(), '활동중', now()),
       (31, '강민호', '010-9090-1212', 'minho.kang@arbo.go.kr', now(), '휴직', now()),
       (32, '조서현', '010-1234-9876', 'seohyun.jo@greenlab.co.kr', now(), '활동중', now()),
       (33, '윤준영', '010-9876-5432', 'junyoung.yoon@treecare.kr', now(), '활동중', now()),
       (34, '임소연', '010-5432-1098', 'soyeon.lim@eco.go.kr', now(), '활동중', now()),
       (35, '한동욱', '010-1098-7654', 'dongwook.han@forest.co.kr', now(), '퇴직', now()),
       (36, '오지은', '010-7654-3210', 'jieun.oh@arborist.co.kr', now(), '활동중', now()),
       (37, '신우현', '010-3210-6789', 'woohyun.shin@greentech.kr', now(), '활동중', now()),
       (38, '권나영', '010-6789-4321', 'nayoung.kwon@treeman.co.kr', now(), '휴직', now()),
       (39, '남도윤', '010-4321-8765', 'doyun.nam@eco.kr', now(), '활동중', now()),
       (40, '황지훈', '010-8765-2109', 'jihoon.hwang@forest.go.kr', now(), '활동중', now()),
       (41, '유서아', '010-2109-6543', 'seoa.yu@arbo.co.kr', now(), '활동중', now()),
       (42, '배민준', '010-6543-0987', 'minjun.bae@greenlab.kr', now(), '퇴직', now()),
       (43, '서하린', '010-0987-4321', 'harin.seo@treecare.co.kr', now(), '활동중', now()),
       (44, '문준서', '010-4321-5678', 'junseo.moon@eco.co.kr', now(), '활동중', now()),
       (45, '류채은', '010-5678-8765', 'chaeeun.ryu@forest.kr', now(), '휴직', now()),
       (46, '노태준', '010-8765-1234', 'taejun.no@arborist.go.kr', now(), '활동중', now()),
       (47, '홍수민', '010-1234-0000', 'sumin.hong@greentech.co.kr', now(), '활동중', now()),
       (48, '전지호', '010-0000-9999', 'jiho.jeon@treeman.kr', now(), '활동중', now()),
       (49, '송아영', '010-9999-1111', 'ayoung.song@eco.go.kr', now(), '퇴직', now()),
       (50, '안현수', '010-1111-8888', 'hyunsu.ahn@forest.co.kr', now(), '활동중', now()),
       (51, '김나현', '010-8888-2222', 'nahyun.kim@arbo.kr', now(), '활동중', now()),
       (52, '이준호', '010-2222-7777', 'junho.lee@greenlab.co.kr', now(), '휴직', now()),
       (53, '박다은', '010-7777-3333', 'daeun.park@treecare.kr', now(), '활동중', now()),
       (54, '최승현', '010-3333-6666', 'seunghyun.choi@eco.kr', now(), '활동중', now()),
       (55, '정유나', '010-6666-4444', 'yuna.jung@forest.go.kr', now(), '활동중', now()),
       (56, '강지호', '010-4444-5555', 'jiho.kang@arborist.co.kr', now(), '퇴직', now()),
       (57, '조민아', '010-5555-2222', 'mina.jo@greentech.kr', now(), '활동중', now()),
       (58, '윤태현', '010-2222-4444', 'taehyun.yoon@treeman.co.kr', now(), '활동중', now()),
       (59, '임하늘', '010-4444-1111', 'haneul.lim@eco.co.kr', now(), '휴직', now()),
       (60, '한지수', '010-1111-3333', 'jisu.han@forest.kr', now(), '활동중', now()),
       (61, '오민석', '010-3333-8888', 'minseok.oh@arbo.go.kr', now(), '활동중', now()),
       (62, '신채연', '010-8888-6666', 'chaeyeon.shin@greenlab.kr', now(), '활동중', now()),
       (63, '권도현', '010-6666-2222', 'dohyun.kwon@treecare.co.kr', now(), '퇴직', now()),
       (64, '남수진', '010-2222-9999', 'sujin.nam@eco.go.kr', now(), '활동중', now()),
       (65, '황준혁', '010-9999-4444', 'junhyuk.hwang@forest.co.kr', now(), '활동중', now()),
       (66, '유민경', '010-4444-7777', 'minkyung.yu@arborist.kr', now(), '휴직', now()),
       (67, '배지훈', '010-7777-5555', 'jihoon.bae@greentech.co.kr', now(), '활동중', now()),
       (68, '서수아', '010-5555-1111', 'sua.seo@treeman.kr', now(), '활동중', now()),
       (69, '문태양', '010-1111-6666', 'taeyang.moon@eco.kr', now(), '활동중', now()),
       (70, '류현우', '010-6666-3333', 'hyunwoo.ryu@forest.go.kr', now(), '퇴직', now()),
       (71, '노지아', '010-3333-5555', 'jia.no@arbo.co.kr', now(), '활동중', now()),
       (72, '홍도현', '010-5555-9999', 'dohyun.hong@greenlab.co.kr', now(), '활동중', now()),
       (73, '전하은', '010-9999-2222', 'haeun.jeon@treecare.kr', now(), '휴직', now()),
       (74, '송승준', '010-2222-6666', 'seungjun.song@eco.co.kr', now(), '활동중', now()),
       (75, '안예린', '010-6666-8888', 'yerin.ahn@forest.kr', now(), '활동중', now()),
       (76, '김지원', '010-8888-4444', 'jiwon.kim@arborist.co.kr', now(), '활동중', now()),
       (77, '이민서', '010-4444-2222', 'minseo.lee@greentech.kr', now(), '퇴직', now()),
       (78, '박준혁', '010-2222-5555', 'junhyuk.park@treeman.co.kr', now(), '활동중', now()),
       (79, '최나연', '010-5555-7777', 'nayeon.choi@eco.go.kr', now(), '활동중', now()),
       (80, '정동현', '010-7777-1111', 'donghyun.jung@forest.co.kr', now(), '휴직', now()),
       (81, '강채원', '010-1111-9999', 'chaewon.kang@arbo.kr', now(), '활동중', now()),
       (82, '조지성', '010-9999-5555', 'jisung.jo@greenlab.kr', now(), '활동중', now()),
       (83, '윤은서', '010-5555-3333', 'eunseo.yoon@treecare.co.kr', now(), '활동중', now()),
       (84, '임준서', '010-3333-7777', 'junseo.lim@eco.kr', now(), '퇴직', now()),
       (85, '한소율', '010-7777-2222', 'soyul.han@forest.go.kr', now(), '활동중', now()),
       (86, '오민재', '010-2222-8888', 'minjae.oh@arborist.kr', now(), '활동중', now()),
       (87, '신지후', '010-8888-3333', 'jihoo.shin@greentech.co.kr', now(), '휴직', now()),
       (88, '권태리', '010-3333-1111', 'taeri.kwon@treeman.kr', now(), '활동중', now()),
       (89, '남현진', '010-1111-7777', 'hyunjin.nam@eco.co.kr', now(), '활동중', now()),
       (90, '황수현', '010-7777-4444', 'suhyun.hwang@forest.kr', now(), '활동중', now()),
       (91, '유지민', '010-4444-6666', 'jimin.yu@arbo.go.kr', now(), '퇴직', now()),
       (92, '배하준', '010-6666-1111', 'hajun.bae@greenlab.co.kr', now(), '활동중', now()),
       (93, '서민호', '010-1111-5555', 'minho.seo@treecare.kr', now(), '활동중', now()),
       (94, '문서현', '010-5555-4444', 'seohyun.moon@eco.go.kr', now(), '휴직', now()),
       (95, '류준영', '010-4444-9999', 'junyoung.ryu@forest.co.kr', now(), '활동중', now()),
       (96, '노소연', '010-9999-6666', 'soyeon.no@arborist.co.kr', now(), '활동중', now()),
       (97, '홍동욱', '010-6666-5555', 'dongwook.hong@greentech.kr', now(), '활동중', now()),
       (98, '전지은', '010-5555-8888', 'jieun.jeon@treeman.co.kr', now(), '퇴직', now()),
       (99, '송민호', '010-8888-7777', 'minho.song@eco.go.kr', now(), '활동중', now()),
       (100, '안채린', '010-7777-6666', 'chaerin.ahn@forest.co.kr', now(), '활동중', now());
-- ================================= 답사신청테이블 샘플 코드  =================================
INSERT INTO application
(member_id, expert_id, times, survey_status, due_date, content, opinion, create_date, update_date)
VALUES (1, 11,  0, '신청', '2025-06-01 10:00:00', '공원 나무 상태 점검 요청', NULL, now(), now()),
       (1, 12,  1, '완료', '2025-06-02 11:00:00', '은행나무 병충해 확인 요청', NULL, now(), now()),
       (2, 13,  0, '신청', '2025-06-03 09:30:00', '벚나무 가지 상태 점검', NULL, now(), now()),
       (1, 14, 2, '진행중', '2025-06-04 14:00:00', '느티나무 쓰러짐 위험 확인', '안전조치 필요', now(), now()),
       (3, 15,  0, '신청', '2025-06-05 13:00:00', '단풍나무 잎 변색 확인 요청', NULL, now(), now()),
       (3, 11,  1, '진행중', '2025-06-06 10:30:00', '소나무 생육 상태 확인', NULL, now(), now()),
       (4, 12,  0, '신청', '2025-06-07 15:20:00', '가로수 가지치기 필요', NULL, now(), now()),
       (4, 13, 1, '진행중', '2025-06-08 16:00:00', '나무 기울어짐 점검', NULL, now(), now()),
       (5, 14,  0, '완료', '2025-06-09 12:40:00', '뿌리 노출 문제 확인', '토양 보강 필요', now(), now()),
       (6, 15, 0, '신청', '2025-06-10 11:15:00', '나무 병충해 의심', NULL, now(), now()),
       (7, 11,  0, '진행중', '2025-06-11 09:50:00', '수목 성장 상태 조사', NULL, now(), now()),
       (8, 12,  0, '신청', '2025-06-12 13:10:00', '공원 수목 점검 요청', NULL, now(), now()),
       (9, 13,  0, '진행중', '2025-06-13 14:30:00', '가지 부러짐 확인 요청', NULL, now(), now()),
       (10, 14,  0, '완료', '2025-06-14 10:00:00', '나무 줄기 균열 확인', '지지대 설치 권장', now(), now()),
       (11, 15,  0, '신청', '2025-06-15 11:40:00', '단풍나무 상태 확인 요청', NULL, now(), now()),
       (12, 11,  1, '진행중', '2025-06-16 15:00:00', '소나무 가지 상태 점검', NULL, now(), now()),
       (13, 12,  0, '신청', '2025-06-17 09:00:00', '은행나무 열매 낙하 문제', NULL, now(), now()),
       (14, 13,  1, '진행중', '2025-06-18 16:10:00', '벚나무 병충해 의심', NULL, now(), now()),
       (15, 14, 0, '완료', '2025-06-19 13:20:00', '느티나무 뿌리 문제 확인', '토양 정비 필요', now(), now()),
       (16, 15,  0, '신청', '2025-06-20 10:10:00', '수목 전반 상태 점검 요청', NULL, now(), now());
-- ================================= 나무기록테이블 샘플 코드  =================================
insert into expert_report (detail_id, tree_type, dbh, tree_status, picture, height, width, create_date, update_date)
values (1, '소나무', 25, '양호', 'https://picsum.photos/seed/tree1/400/300', 12, 8, now(), now()),
       (1, '참나무', 30, '양호', 'https://picsum.photos/seed/tree2/400/300', 15, 10, now(), now()),
       (2, '은행나무', 45, '보통', 'https://picsum.photos/seed/tree3/400/300', 18, 12, now(), now()),
       (2, '벚나무', 20, '양호', 'https://picsum.photos/seed/tree4/400/300', 10, 7, now(), now()),
       (3, '단풍나무', 18, '불량', 'https://picsum.photos/seed/tree5/400/300', 8, 5, now(), now()),
       (3, '소나무', 35, '양호', 'https://picsum.photos/seed/tree6/400/300', 14, 9, now(), now()),
       (4, '느티나무', 60, '양호', 'https://picsum.photos/seed/tree7/400/300', 20, 15, now(), now()),
       (4, '참나무', 28, '보통', 'https://picsum.photos/seed/tree8/400/300', 13, 8, now(), now()),
       (5, '향나무', 22, '양호', 'https://picsum.photos/seed/tree9/400/300', 9, 6, now(), now()),
       (5, '메타세쿼이아', 40, '양호', 'https://picsum.photos/seed/tree10/400/300', 25, 7, now(), now()),
       (6, '소나무', 32, '보통', 'https://picsum.photos/seed/tree11/400/300', 11, 8, now(), now()),
       (6, '자작나무', 15, '양호', 'https://picsum.photos/seed/tree12/400/300', 9, 5, now(), now()),
       (7, '느티나무', 55, '양호', 'https://picsum.photos/seed/tree13/400/300', 22, 14, now(), now()),
       (7, '벚나무', 25, '불량', 'https://picsum.photos/seed/tree14/400/300', 10, 6, now(), now()),
       (8, '은행나무', 38, '보통', 'https://picsum.photos/seed/tree15/400/300', 16, 10, now(), now()),
       (8, '단풍나무', 20, '양호', 'https://picsum.photos/seed/tree16/400/300', 9, 6, now(), now()),
       (9, '참나무', 42, '양호', 'https://picsum.photos/seed/tree17/400/300', 18, 12, now(), now()),
       (9, '소나무', 27, '보통', 'https://picsum.photos/seed/tree18/400/300', 12, 7, now(), now()),
       (10, '편백', 30, '양호', 'https://picsum.photos/seed/tree19/400/300', 14, 6, now(), now()),
       (10, '향나무', 18, '양호', 'https://picsum.photos/seed/tree20/400/300', 8, 5, now(), now()),
       (11, '느릅나무', 35, '보통', 'https://picsum.photos/seed/tree21/400/300', 15, 9, now(), now()),
       (11, '소나무', 29, '양호', 'https://picsum.photos/seed/tree22/400/300', 13, 8, now(), now()),
       (12, '메타세쿼이아', 45, '양호', 'https://picsum.photos/seed/tree23/400/300', 28, 8, now(), now()),
       (12, '벚나무', 22, '보통', 'https://picsum.photos/seed/tree24/400/300', 10, 7, now(), now()),
       (13, '은행나무', 50, '양호', 'https://picsum.photos/seed/tree25/400/300', 20, 13, now(), now()),
       (13, '참나무', 33, '양호', 'https://picsum.photos/seed/tree26/400/300', 16, 10, now(), now()),
       (14, '단풍나무', 17, '불량', 'https://picsum.photos/seed/tree27/400/300', 7, 4, now(), now()),
       (14, '소나무', 36, '양호', 'https://picsum.photos/seed/tree28/400/300', 15, 9, now(), now()),
       (15, '자작나무', 20, '양호', 'https://picsum.photos/seed/tree29/400/300', 11, 6, now(), now()),
       (15, '느티나무', 48, '보통', 'https://picsum.photos/seed/tree30/400/300', 19, 12, now(), now()),
       (16, '향나무', 25, '양호', 'https://picsum.photos/seed/tree31/400/300', 10, 7, now(), now()),
       (16, '편백', 28, '양호', 'https://picsum.photos/seed/tree32/400/300', 13, 6, now(), now()),
       (17, '소나무', 31, '보통', 'https://picsum.photos/seed/tree33/400/300', 12, 8, now(), now()),
       (17, '참나무', 38, '양호', 'https://picsum.photos/seed/tree34/400/300', 17, 11, now(), now()),
       (18, '벚나무', 19, '양호', 'https://picsum.photos/seed/tree35/400/300', 9, 6, now(), now()),
       (18, '은행나무', 42, '보통', 'https://picsum.photos/seed/tree36/400/300', 17, 11, now(), now()),
       (19, '느티나무', 62, '양호', 'https://picsum.photos/seed/tree37/400/300', 23, 16, now(), now()),
       (19, '단풍나무', 21, '양호', 'https://picsum.photos/seed/tree38/400/300', 10, 6, now(), now()),
       (20, '메타세쿼이아', 37, '양호', 'https://picsum.photos/seed/tree39/400/300', 22, 7, now(), now()),
       (20, '소나무', 26, '불량', 'https://picsum.photos/seed/tree40/400/300', 11, 7, now(), now());

-- ================================= 수종별 탄소흡수 계수 (tree_coefficient) =================================
-- 상대생장식: W = a × (DBH² × H)^b
-- 수령추정: age = c × DBH^d
-- 탄소: CO₂(kg) = W × BEF × (1+R) × CF × (44/12)

-- 침엽수/활엽수 통합 계수 (2건만)
INSERT INTO tree_coefficient (tree_name, tree_type, a_value, b_value, density, bef, root_ratio, carbon_fraction, agecvalue, agedvalue, dbh_growth, height_growth, is_default)
VALUES ('침엽수', 'CONIFER', 0.0750, 0.9300, 0.45, 1.43, 0.27, 0.51, 2.00, 0.83, 0.6, 0.4, true);
INSERT INTO tree_coefficient (tree_name, tree_type, a_value, b_value, density, bef, root_ratio, carbon_fraction, agecvalue, agedvalue, dbh_growth, height_growth, is_default)
VALUES ('활엽수', 'BROADLEAF', 0.1300, 0.8800, 0.68, 1.51, 0.36, 0.48, 1.80, 0.87, 0.8, 0.5, true);