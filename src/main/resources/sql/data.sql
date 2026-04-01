-- ================================= 지역코드 마스터 (17개 시도) =================================
INSERT INTO region_code (region_id, region_name, nx, ny)
VALUES (1, '서울', 60, 127);
INSERT INTO region_code (region_id, region_name, nx, ny)
VALUES (2, '부산', 98, 76);
INSERT INTO region_code (region_id, region_name, nx, ny)
VALUES (3, '대구', 89, 90);
INSERT INTO region_code (region_id, region_name, nx, ny)
VALUES (4, '인천', 55, 124);
INSERT INTO region_code (region_id, region_name, nx, ny)
VALUES (5, '광주', 58, 74);
INSERT INTO region_code (region_id, region_name, nx, ny)
VALUES (6, '대전', 67, 100);
INSERT INTO region_code (region_id, region_name, nx, ny)
VALUES (7, '울산', 102, 84);
INSERT INTO region_code (region_id, region_name, nx, ny)
VALUES (8, '세종', 66, 103);
INSERT INTO region_code (region_id, region_name, nx, ny)
VALUES (9, '경기', 60, 120);
INSERT INTO region_code (region_id, region_name, nx, ny)
VALUES (10, '강원', 73, 134);
INSERT INTO region_code (region_id, region_name, nx, ny)
VALUES (11, '충북', 69, 107);
INSERT INTO region_code (region_id, region_name, nx, ny)
VALUES (12, '충남', 68, 100);
INSERT INTO region_code (region_id, region_name, nx, ny)
VALUES (13, '전북', 63, 89);
INSERT INTO region_code (region_id, region_name, nx, ny)
VALUES (14, '전남', 51, 67);
INSERT INTO region_code (region_id, region_name, nx, ny)
VALUES (15, '경북', 89, 91);
INSERT INTO region_code (region_id, region_name, nx, ny)
VALUES (16, '경남', 91, 77);
INSERT INTO region_code (region_id, region_name, nx, ny)
VALUES (17, '제주', 52, 38);
-- ================================= 기업 샘플 데이터 =================================
INSERT INTO company (company_id, company_name, business_number, ceo_name, start_date, address, business_license,
                     is_approved, create_date, update_date)
VALUES (1, '삼성전자', '124-81-00998', '이재용', '19690113', '경기도 수원시 영통구 삼성로 129', null, 1, now(), now()),
       (2, '카카오', '120-81-47521', '정신아', '20060203', '제주특별자치도 제주시 첨단로 242', null, 1, now(), now()),
       (3, '네이버', '220-81-62517', '최수연', '19990602', '경기도 성남시 분당구 불정로 6', null, 1, now(), now()),
       (4, 'LG전자', '107-86-14075', '조주완', '19580101', '서울특별시 영등포구 여의대로 128', null, 1, now(), now()),
       (5, 'SK하이닉스', '129-81-09558', '곽노정', '19830201', '경기도 이천시 부발읍 이천대로 2091', null, 1, now(), now()),
       (6, '현대자동차', '107-81-18268', '장재훈', '19670329', '서울특별시 서초구 헌릉로 12', null, 0, now(), now()),     -- 대기
       (7, '기아', '106-81-16643', '송호성', '19440609', '서울특별시 서초구 헌릉로 12', null, 1, now(), now()),
       (8, 'SK텔레콤', '220-81-00264', '유영상', '19840303', '서울특별시 중구 을지로 65', null, 1, now(), now()),
       (9, 'KT', '502-81-13601', '김영섭', '19810101', '경기도 성남시 분당구 불정로 90', null, 1, now(), now()),
       (10, 'LG유플러스', '032-86-07750', '황현식', '19960401', '서울특별시 용산구 한강대로 32', null, 0, now(), now()),  -- 대기
       (11, '포스코', '107-81-18366', '장인화', '19680401', '서울특별시 강남구 테헤란로 440', null, 1, now(), now()),
       (12, 'KB국민은행', '408-81-39950', '이재근', '19631001', '서울특별시 영등포구 국제금융로 8', null, 1, now(), now()),
       (13, '신한은행', '100-81-02535', '정상혁', '19820701', '서울특별시 중구 세종대로 9', null, 1, now(), now()),
       (14, '하나은행', '138-81-00220', '이승열', '19710201', '서울특별시 중구 을지로 66', null, 1, now(), now()),
       (15, '우리은행', '202-81-00197', '조병규', '19991227', '서울특별시 중구 소공로 51', null, 1, now(), now()),
       (16, '롯데케미칼', '107-81-18672', '신동빈', '19760201', '서울특별시 영등포구 여의대로 128', null, 0, now(), now()), -- 대기
       (17, 'CJ제일제당', '110-81-02149', '최은석', '19530101', '서울특별시 중구 동호로 330', null, 1, now(), now()),
       (18, '두산에너빌리티', '113-81-00202', '박지원', '19621001', '경상남도 창원시 성산구 두산볼보로 22', null, 1, now(), now()),
       (19, 'HD현대', '120-81-00260', '정기선', '20021001', '경기도 성남시 분당구 판교로 344', null, 1, now(), now()),
       (20, 'GS칼텍스', '130-81-05064', '허세홍', '19670101', '서울특별시 강남구 논현로 508', null, 1, now(), now());

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

-- is_admin: 0 일반, 1 관리자
-- is_approved: 0 대기, 1 승인, 2 거절
INSERT INTO member (member_id, company_id, member_name, password, party_name, company_number, email, address,
                    is_approved, is_admin, create_date, update_date)
VALUES (1, 4, 'tech_vision_01', '$2b$12$f8tJbai9YbFKqWWpYWoNRuZ5uamT.AsjSHp3LHvQsv22ydxDhzx4m', '김도윤', '010-2938-1029',
        'dy.kim@techvision.co.kr', '서울특별시 강남구 테헤란로 427', 1, 0, now(), now()),
       (2, 1, 'blue_ocean_intl', '$2b$12$O9WT/AW9ooIy8Jj72XQ4Tu/bZG6wjdeM5VNtxGmvtnxlR.TluOyba', '이현우', '010-8821-3304',
        'hwlee@blueocean.com', '경기도 성남시 분당구 판교역로 166', 1, 0, now(), now()),
       (3, 9, 'green_farm_korea', '$2b$12$PF4Fps0hjrM5tvCKpcOZduwfyff57Z409jrWcHIJsYzfLiohpW1su', '박서준',
        '010-4456-7812', 'seo_jun@greenfarm.kr', '전라남도 나주시 빛가람로 350', 0, 0, now(), now()),      -- 대기
       (4, 8, 'smart_logic_lab', '$2b$12$oD9n6kltZn7o1jx42UTMV.tW39iCAfbLZYD55zojMmKjQcR3530G.', '최하은', '010-5567-1123',
        'haeun.choi@smartlogic.io', '서울특별시 구로구 디지털로 300', 1, 0, now(), now()),
       (5, 8, 'global_logis_sys', '$2b$12$GjE1DXPbN0Rewnw48kAMUeVHi8dqbs.DwLUGXljO49CO9S4atSQ9e', '정민호',
        '010-9901-2234', 'mh.jung@globallogis.net', '부산광역시 강서구 유통단지로 23', 1, 0, now(), now()),
       (6, 5, 'future_mob_dev', '$2b$12$2wyWMuTCcev4F8vK2eXWWeOH15bWdG5G7heAI0P94o84oMsHwyqnO', '강지안', '010-3345-6678',
        'jian.kang@futuremob.co.kr', '경기도 화성시 삼성로 1', 1, 0, now(), now()),
       (7, 4, 'creative_ads_kr', '$2b$12$/Fm2MH/0m72OWcawU99xYO0wkIL1E/3hfygLbH9UF1zRUHHoNoJcy', '윤소희', '010-7788-9901',
        'sh.yoon@creativeads.com', '서울특별시 마포구 양화로 144', 0, 0, now(), now()),                    -- 대기
       (8, 18, 'health_care_plus', '$2b$12$3CVA8FiSqXsK1tctusmVB.MNT1mFQZP/pUztkdS/BEJwiKSelpjIm', '한준영',
        '010-2211-4433', 'jy.han@healthcareplus.kr', '대구광역시 중구 달구벌대로 2077', 1, 0, now(), now()),
       (9, 3, 'urban_design_st', '$2b$12$nyQ/DHK3oxcxlcZqp9Hh0Os7i0/CHn.V8p9X/w7w89AFXKoV2eOrm', '송미경', '010-6655-1100',
        'mk.song@urbandesign.co.kr', '서울특별시 성동구 성수이로 113', 1, 0, now(), now()),
       (10, 19, 'mega_store_dist', '$2b$12$WHmlmkL1Q/DpRDpkpJGnNOTI1zfqV6SL2hvlNmioL4kD1Cx2dUxt2', '임재상',
        '010-4499-8822', 'js.lim@megastore.co.kr', '인천광역시 부평구 부평대로 20', 1, 0, now(), now()),
       (11, 14, 'cloud_infra_sol', '$2b$12$jK.Lt0/ccdbhvPe3yo.7U.vEZ3kjf4NnpymKRYEraPTzTWA7TH95O', '박준영',
        '010-3388-1122', 'jy.park@cloudinfra.co.kr', '서울특별시 서초구 서초대로 301', 0, 0, now(), now()), -- 대기
       (12, 2, 'neo_medical_kr', '$2b$12$9S0KE7OZEK1VXU8JDiHhqetKid9ALxbMIUu5xa/vE7CD5I.DBuHlO', '이서연', '010-7744-8899',
        'sy.lee@neomed.kr', '경기도 수원시 영통구 광교중앙로', 1, 0, now(), now()),
       (13, 1, 'atlas_heavy_ind', '$2b$12$aYk4tkfH7VYB6pXDUsh8qeqOLU63LdAH8vSKeQiPzzukbl6f29Kp6', '최동현',
        '010-2211-5544', 'dh.choi@atlasind.com', '울산광역시 동구 방어진순환도로', 1, 0, now(), now()),
       (14, 3, 'vision_it_group', '$2b$12$pfRbPDBsoQoHvmkP4n0aAu0q7McZhStUQt2likCj0YGES0iUMomVa', '김민지',
        '010-4455-2233', 'mj.kim@visionit.io', '서울특별시 금천구 가산디지털1로', 1, 0, now(), now()),
       (15, 7, 'k_logistics_net', '$2b$12$7dN/O6tBHe4zm2aOBR412uw51uTKhP/aDqQ/jy5.gU0UAMByOK3fa', '정태우',
        '010-9988-7766', 'tw.jung@klogis.net', '인천광역시 중구 공항동로 295', 1, 0, now(), now()),
       (16, 8, 'urban_re_mgt', '$2b$12$2fNrxcVvgmgeILczuTJfM.Dp9uBkoexJeQCD.JywQdrt9Fl3v4oFK', '황수진', '010-1133-4422',
        'sj.hwang@urbanmgt.co.kr', '서울특별시 종로구 율곡로 6', 1, 0, now(), now()),
       (17, 17, 'eco_power_tech', '$2b$12$JYQLo0cN1xdtlXTq736bse2rl8gXq593rqXswr83RYPrZnT6v.5Bu', '안재현',
        '010-5566-3311', 'jh.ahn@ecopower.kr', '전라남도 나주시 전력로 11', 1, 0, now(), now()),
       (18, 20, 'global_edu_plus', '$2b$12$.yYKJ6N8iAiXQubn2sSdseeCyEF7auTFosFkCtwGhWLn/PoAvgjHW', '윤하은',
        '010-8811-9922', 'he.yoon@eduplus.com', '서울특별시 강남구 역삼로 415', 1, 0, now(), now()),
       (19, 1, 'smart_iot_lab', '$2b$12$78ZIBwoR9EjnReyCbHS/Fu9Z2Yn4EU2GfJgLvJRAqqHU8S2NrVG7y', '박성민', '010-2244-6688',
        'sm.park@smartiot.io', '경기도 성남시 수정구 창업로 40', 1, 0, now(), now()),
       (20, 18, 'prime_food_sys', '$2b$12$zIaarbB2t4z0q9myCXGqqu6YC.n/ZDhz97S1nBzDIw/980d.ABnRy', '강도윤',
        '010-7799-1155', 'dy.kang@primefood.co.kr', '충청북도 음성군 원남면 원남산단로', 1, 0, now(), now()),
-- 관리자 계정 (비밀번호: admin1234)
       (21, 1, 'admin', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lHHG', '관리자', '010-0000-0000',
        'admin@greenzone.com', '서울특별시 강남구 테헤란로 427', 1, 1, now(), now());
-- ================================= 전문가테이블 샘플 코드  =================================
INSERT INTO expert ( expert_name, expert_number, expert_email, expert_state, s_address, create_date,
                    update_date)
VALUES ( '김철수', '010-1111-0001', 'chul1@green.com', '가용', '서울특별시 강남구 테헤란로 10', NOW(), NOW()),
       ( '이영희', '010-2222-0002', 'young2@green.com', '파견', '부산광역시 해운대구 우동 20', NOW(), NOW()),
       ( '박지민', '010-3333-0003', 'jimin3@green.com', '가용', '대구광역시 중구 중앙대로 30', NOW(), NOW()),
       ( '최수호', '010-4444-0004', 'suho4@green.com', '휴직', '인천광역시 미추홀구 주안동 40', NOW(), NOW()),
       ( '정다은', '010-5555-0005', 'daeun5@green.com', '가용', '광주광역시 북구 설죽로 50', NOW(), NOW()),
       ( '강민호', '010-6666-0006', 'min6@green.com', '퇴직', '대전광역시 서구 둔산로 60', NOW(), NOW()),
       ( '윤서연', '010-7777-0007', 'seo7@green.com', '파견', '울산광역시 남구 삼산로 70', NOW(), NOW()),
       ( '임도현', '010-8888-0008', 'do8@green.com', '가용', '세종특별자치시 도움8로 80', NOW(), NOW()),
       ( '한지아', '010-9999-0009', 'jia9@green.com', '가용', '경기도 안양시 동안구 시민대로 90', NOW(), NOW()),
       ( '오지훈', '010-1234-0010', 'hun10@green.com', '파견', '강원특별자치도 춘천시 중앙로 100', NOW(), NOW()),
       ( '송미경', '010-2345-0011', 'song11@green.com', '가용', '충청북도 청주시 상당구 110', NOW(), NOW()),
       ( '권태윤', '010-3456-0012', 'kwon12@green.com', '휴직', '충청남도 천안시 서북구 120', NOW(), NOW()),
       ( '신재이', '010-4567-0013', 'shin13@green.com', '가용', '전북특별자치도 전주시 완산구 130', NOW(), NOW()),
       ( '황준서', '010-5678-0014', 'hwang14@green.com', '퇴직', '전라남도 목포시 통일대로 140', NOW(), NOW()),
       ( '백지혜', '010-6789-0015', 'baek15@green.com', '파견', '경상북도 포항시 남구 150', NOW(), NOW()),
       ( '유하은', '010-7890-0016', 'yu16@green.com', '가용', '경상남도 창원시 성산구 160', NOW(), NOW()),
       ( '조성민', '010-8901-0017', 'cho17@green.com', '가용', '제주특별자치도 제주시 노형로 170', NOW(), NOW()),
       ( '문지혜', '010-9012-0018', 'moon18@green.com', '파견', '경기도 수원시 영통구 180', NOW(), NOW()),
       ( '양준혁', '010-0123-0019', 'yang19@green.com', '가용', '서울특별시 송파구 올림픽로 190', NOW(), NOW()),
       ( '서예지', '010-1357-0020', 'seo20@green.com', '휴직', '부산광역시 수영구 광안동 200', NOW(), NOW()),
       ( '노현우', '010-2468-0021', 'roh21@green.com', '가용', '대구광역시 수성구 범어동 210', NOW(), NOW()),
       ( '배유나', '010-1122-0022', 'bae22@green.com', '퇴직', '인천광역시 연수구 송도동 220', NOW(), NOW()),
       ( '고진우', '010-5566-0023', 'ko23@green.com', '가용', '광주광역시 남구 봉선동 230', NOW(), NOW()),
       ( '전효진', '010-9900-0024', 'jeon24@green.com', '파견', '대전광역시 유성구 대학로 240', NOW(), NOW()),
       ( '남궁민', '010-3344-0025', 'nam25@green.com', '가용', '울산광역시 중구 성남동 250', NOW(), NOW()),
       ( '심규현', '010-7788-0026', 'sim26@green.com', '휴직', '경기도 고양시 일산동구 260', NOW(), NOW()),
       ( '홍길동', '010-1212-0027', 'hong27@green.com', '가용', '강원특별자치도 원주시 무실동 270', NOW(), NOW()),
       ( '차은우', '010-5656-0028', 'cha28@green.com', '파견', '충청북도 충주시 중앙탑면 280', NOW(), NOW()),
       ( '안유진', '010-9090-0029', 'an29@green.com', '가용', '충청남도 아산시 배방읍 290', NOW(), NOW()),
       ( '장원영', '010-3434-0030', 'jang30@green.com', '퇴직', '전북특별자치도 군산시 300', NOW(), NOW()),
       ( '이강인', '010-7878-0031', 'lee31@green.com', '가용', '전라남도 여수시 시청로 310', NOW(), NOW()),
       ( '손흥민', '010-1231-0032', 'son32@green.com', '파견', '경상북도 경주시 황남동 320', NOW(), NOW()),
       ( '김연아', '010-4564-0033', 'kim33@green.com', '가용', '경상남도 진주시 가좌동 330', NOW(), NOW()),
       ( '박세리', '010-7897-0034', 'park34@green.com', '휴직', '제주특별자치도 서귀포시 340', NOW(), NOW()),
       ( '이정후', '010-1591-0035', 'lee35@green.com', '가용', '경기도 성남시 수정구 350', NOW(), NOW()),
       ( '류현진', '010-3573-0036', 'ryu36@green.com', '파견', '서울특별시 마포구 월드컵로 360', NOW(), NOW()),
       ( '김희애', '010-8528-0037', 'kim37@green.com', '가용', '부산광역시 부산진구 부전동 370', NOW(), NOW()),
       ( '조정석', '010-7417-0038', 'cho38@green.com', '퇴직', '대구광역시 달서구 상인동 380', NOW(), NOW()),
       ( '한소희', '010-9639-0039', 'han39@green.com', '가용', '인천광역시 부평구 부평동 390', NOW(), NOW()),
       ( '박보검', '010-1471-0040', 'park40@green.com', '파견', '광주광역시 서구 상무대로 400', NOW(), NOW()),
       ( '정해인', '010-2582-0041', 'jung41@green.com', '가용', '대전광역시 중구 은행동 410', NOW(), NOW()),
       ( '김고은', '010-3693-0042', 'kim42@green.com', '휴직', '울산광역시 북구 매곡동 420', NOW(), NOW()),
       ( '유해진', '010-1234-0043', 'yu43@green.com', '가용', '경기도 용인시 수지구 430', NOW(), NOW()),
       ( '성동일', '010-5678-0044', 'sung44@green.com', '파견', '강원특별자치도 강릉시 440', NOW(), NOW()),
       ( '김혜수', '010-9012-0045', 'kim45@green.com', '가용', '충청북도 제천시 450', NOW(), NOW()),
       ( '마동석', '010-3456-0046', 'ma46@green.com', '퇴직', '충청남도 당진시 460', NOW(), NOW()),
       ( '이병헌', '010-7890-0047', 'lee47@green.com', '가용', '전북특별자치도 익산시 470', NOW(), NOW()),
       ( '전지현', '010-1111-0048', 'jeon48@green.com', '파견', '전라남도 순천시 480', NOW(), NOW()),
       ( '공유', '010-2222-0049', 'gong49@green.com', '가용', '경상북도 구미시 490', NOW(), NOW()),
       ( '아이유', '010-3333-0050', 'iu50@green.com', '휴직', '경상남도 양산시 500', NOW(), NOW());
-- ================================= 답사신청테이블 샘플 코드  =================================
INSERT INTO application (member_id, expert_id, times, survey_status, content, due_date, due_start_date, due_end_date,
                         create_date, update_date)
VALUES (1, 1, 1, '진행중', '여수 공장 견적 확인 요청', '2026-04-01 00:00:00', '2026-04-01 00:00:00', '2026-04-01 00:00:00', NOW(), NOW()),
       ( 2, 2, 0, '신청', '소나무 150 그루 초기 답사', '2026-04-02', '2026-04-11', '2026-04-15', NOW(), NOW()),
       ( 3, 3, 1, '완료', '지점 견적 확인 요청', '2026-03-01', '2026-03-05', '2026-03-08', NOW(), NOW()),
       ( 4, 4, 2, '진행중', '참나무 300 그루 수량 파악', '2026-04-02', '2026-04-11', '2026-04-15', NOW(), NOW()),
       ( 5, 5, 0, '신청', '탄소 배출권 견적 요청', '2026-04-03', '2026-04-12', '2026-04-16', NOW(), NOW()),
       (7, 7, 0, '진행중', '시설 안전 답사 요청', '2026-04-03', '2026-04-12', '2026-04-16', NOW(), NOW()),
       ( 8, 8, 0, '신청', '신규 지점 견적 확인 요청', '2026-04-04', '2026-04-13', '2026-04-17', NOW(), NOW()),
       ( 9, 9, 3, '완료', '느티나무 100 그루 초기 답사', '2026-03-05', '2026-03-10', '2026-03-14', NOW(), NOW()),
       ( 10, 10, 1, '진행중', '지사 견적 확인 요청', '2026-04-04', '2026-04-13', '2026-04-17', NOW(), NOW()),
       ( 1, 11, 0, '신청', '마포 인근 견적 확인 요청', '2026-04-05', '2026-04-14', '2026-04-18', NOW(), NOW()),
       ( 2, 12, 0, '진행중', '편백나무 250 그루 수량 파악', '2026-04-05', '2026-04-14', '2026-04-18', NOW(), NOW()),
       ( 3, 13, 1, '완료', '대구 인근 견적 확인 요청', '2026-03-06', '2026-03-12', '2026-03-16', NOW(), NOW()),
       ( 4, 14, 1, '완료', '은행나무 80 그루 초기 답사', '2026-03-08', '2026-03-15', '2026-03-19', NOW(), NOW()),
       ( 5, 15, 0, '신청', '설비 교체 견적 요청', '2026-04-06', '2026-04-15', '2026-04-20', NOW(), NOW()),
       ( 6, 1, 2, '완료', '나주 공장 견적 확인 요청', '2026-03-10', '2026-03-20', '2026-03-23', NOW(), NOW()),
       ( 7, 16, 0, '진행중', '단풍나무 120 그루 상태 확인', '2026-04-07', '2026-04-16', '2026-04-20', NOW(), NOW()),
       ( 8, 17, 0, '신청', '과천 지역 견적 확인 요청', '2026-04-07', '2026-04-16', '2026-04-20', NOW(), NOW()),
       (9, 18, 0, '완료', '판교 지사 견적 확인 요청', '2026-03-12', '2026-03-22', '2026-03-26', NOW(), NOW()),
       (10, 19, 1, '진행중', '감귤나무 400 그루 초기 답사', '2026-04-08', '2026-04-17', '2026-04-21', NOW(), NOW()),
       (1, 20, 0, '신청', '평택 공장 견적 확인 요청', '2026-04-09', '2026-04-18', '2026-04-22', NOW(), NOW()),
       (2, 21, 2, '완료', '잣나무 200 그루 수량 파악', '2026-03-15', '2026-03-25', '2026-03-29', NOW(), NOW()),
       (3, 22, 1, '진행중', '당진 공장 견적 확인 요청', '2026-04-09', '2026-04-18', '2026-04-22', NOW(), NOW()),
       ( 4, 23, 0, '신청', '원주 지점 견적 확인 요청', '2026-04-10', '2026-04-19', '2026-04-23', NOW(), NOW()),
       ( 5, 24, 1, '완료', '배나무 300 그루 초기 답사', '2026-03-18', '2026-03-28', '2026-04-01', NOW(), NOW()),
       ( 6, 25, 1, '진행중', '익산 지사 견적 확인 요청', '2026-04-10', '2026-04-19', '2026-04-23', NOW(), NOW()),
       ( 7, 26, 0, '신청', '주목 150 그루 상태 확인', '2026-04-10', '2026-04-20', '2026-04-24', NOW(), NOW()),
       ( 8, 27, 1, '진행중', '포항 공장 견적 확인 요청', '2026-04-11', '2026-04-20', '2026-04-24', NOW(), NOW()),
       (9, 28, 0, '신청', '창원 지점 견적 확인 요청', '2026-04-11', '2026-04-21', '2026-04-25', NOW(), NOW()),
       ( 10, 29, 3, '완료', '측백나무 200 그루 수량 파악', '2026-02-20', '2026-03-01', '2026-03-05', NOW(), NOW()),
       (1, 30, 1, '진행중', '진주 지점 견적 확인 요청', '2026-04-12', '2026-04-21', '2026-04-25', NOW(), NOW()),
       ( 2, 31, 0, '신청', '소나무 350 그루 초기 답사', '2026-04-12', '2026-04-22', '2026-04-26', NOW(), NOW()),
       (3, 32, 2, '완료', '천안 지점 견적 확인 요청', '2026-02-21', '2026-03-02', '2026-03-06', NOW(), NOW()),
       (4, 33, 1, '진행중', '성남 지점 견적 확인 요청', '2026-04-13', '2026-04-22', '2026-04-26', NOW(), NOW()),
       (5, 34, 0, '완료', '상수리나무 100 그루 초기 답사', '2026-02-22', '2026-03-03', '2026-03-07', NOW(), NOW()),
       (6, 35, 0, '신청', '용인 지사 견적 확인 요청', '2026-04-13', '2026-04-23', '2026-04-27', NOW(), NOW()),
       ( 7, 1, 2, '진행중', '전나무 180 그루 수량 파악', '2026-04-14', '2026-04-23', '2026-04-27', NOW(), NOW()),
       ( 8, 2, 1, '완료', '군포 지점 견적 확인 요청', '2026-02-23', '2026-03-04', '2026-03-08', NOW(), NOW()),
       ( 9, 3, 0, '신청', '가문비나무 220 그루 초기 답사', '2026-04-14', '2026-04-24', '2026-04-28', NOW(), NOW()),
       ( 10, 4, 1, '진행중', '김포 공장 견적 확인 요청', '2026-04-15', '2026-04-24', '2026-04-28', NOW(), NOW()),
       (1, 5, 3, '완료', '느티나무 140 그루 상태 확인', '2026-02-25', '2026-03-05', '2026-03-09', NOW(), NOW()),
       ( 2, 6, 1, '진행중', '의왕 공장 견적 확인 요청', '2026-04-16', '2026-04-25', '2026-04-29', NOW(), NOW()),
       ( 3, 7, 0, '신청', '소나무 300 그루 초기 답사', '2026-04-16', '2026-04-25', '2026-04-29', NOW(), NOW()),
       ( 4, 8, 0, '진행중', '양주 공장 견적 확인 요청', '2026-04-17', '2026-04-26', '2026-04-30', NOW(), NOW()),
       ( 5, 9, 1, '완료', '자작나무 400 그루 수량 파악', '2026-02-26', '2026-03-07', '2026-03-11', NOW(), NOW()),
       ( 6, 10, 0, '신청', '파주 공장 견적 확인 요청', '2026-04-17', '2026-04-27', '2026-05-01', NOW(), NOW()),
       ( 7, 11, 2, '진행중', '벚나무 150 그루 상태 확인', '2026-04-18', '2026-04-27', '2026-05-01', NOW(), NOW()),
       ( 8, 12, 1, '완료', '포천 공장 견적 확인 요청', '2026-03-01', '2026-03-10', '2026-03-14', NOW(), NOW()),
       ( 9, 13, 0, '신청', '탄소 배출량 측정 요청', '2026-04-19', '2026-04-28', '2026-05-02', NOW(), NOW()),
       ( 10, 14, 1, '진행중', '기존 공장 재답사 요청', '2026-04-19', '2026-04-28', '2026-05-02', NOW(), NOW());
-- ================================= 답사정보 샘플 코드  =================================
insert into expert_report
(detail_id, tree_type, dbh, tree_status, picture, height, width, latitude, longitude, create_date, update_date)
values (1, '소나무', 25, '양호', 'https://picsum.photos/seed/tree1/400/300', 12, 8, 37.5665000, 126.9780000, now(), now()),
       (1, '참나무', 30, '양호', 'https://picsum.photos/seed/tree2/400/300', 15, 10, 37.5651000, 126.9895000, now(), now()),
       (2, '은행나무', 45, '보통', 'https://picsum.photos/seed/tree3/400/300', 18, 12, 35.1796000, 129.0756000, now(), now()),
       (2, '벚나무', 20, '양호', 'https://picsum.photos/seed/tree4/400/300', 10, 7, 35.1802000, 129.0820000, now(), now()),
       (3, '단풍나무', 18, '불량', 'https://picsum.photos/seed/tree5/400/300', 8, 5, 35.8714000, 128.6014000, now(), now()),
       (3, '소나무', 35, '양호', 'https://picsum.photos/seed/tree6/400/300', 14, 9, 35.8722000, 128.6025000, now(), now()),
       (4, '느티나무', 60, '양호', 'https://picsum.photos/seed/tree7/400/300', 20, 15, 37.4563000, 126.7052000, now(), now()),
       (4, '참나무', 28, '보통', 'https://picsum.photos/seed/tree8/400/300', 13, 8, 37.4570000, 126.7080000, now(), now()),
       (5, '향나무', 22, '양호', 'https://picsum.photos/seed/tree9/400/300', 9, 6, 36.3504000, 127.3845000, now(), now()),
       (5, '메타세쿼이아', 40, '양호', 'https://picsum.photos/seed/tree10/400/300', 25, 7, 36.3510000, 127.3852000, now(),
        now()),
       (6, '소나무', 32, '보통', 'https://picsum.photos/seed/tree11/400/300', 11, 8, 35.5384000, 129.3114000, now(), now()),
       (6, '자작나무', 15, '양호', 'https://picsum.photos/seed/tree12/400/300', 9, 5, 35.5390000, 129.3120000, now(), now()),
       (7, '느티나무', 55, '양호', 'https://picsum.photos/seed/tree13/400/300', 22, 14, 37.2636000, 127.0286000, now(),
        now()),
       (7, '벚나무', 25, '불량', 'https://picsum.photos/seed/tree14/400/300', 10, 6, 37.2642000, 127.0300000, now(), now()),
       (8, '은행나무', 38, '보통', 'https://picsum.photos/seed/tree15/400/300', 16, 10, 35.1595000, 126.8526000, now(),
        now()),
       (8, '단풍나무', 20, '양호', 'https://picsum.photos/seed/tree16/400/300', 9, 6, 35.1600000, 126.8535000, now(), now()),
       (9, '참나무', 42, '양호', 'https://picsum.photos/seed/tree17/400/300', 18, 12, 33.4996000, 126.5312000, now(), now()),
       (9, '소나무', 27, '보통', 'https://picsum.photos/seed/tree18/400/300', 12, 7, 33.5002000, 126.5320000, now(), now()),
       (10, '편백', 30, '양호', 'https://picsum.photos/seed/tree19/400/300', 14, 6, 34.7604000, 127.6622000, now(), now()),
       (10, '향나무', 18, '양호', 'https://picsum.photos/seed/tree20/400/300', 8, 5, 34.7610000, 127.6635000, now(), now()),
       (11, '느릅나무', 35, '보통', 'https://picsum.photos/seed/tree21/400/300', 15, 9, 36.0190000, 129.3435000, now(),
        now()),
       (11, '소나무', 29, '양호', 'https://picsum.photos/seed/tree22/400/300', 13, 8, 36.0201000, 129.3442000, now(), now()),
       (12, '메타세쿼이아', 45, '양호', 'https://picsum.photos/seed/tree23/400/300', 28, 8, 35.8242000, 127.1480000, now(),
        now()),
       (12, '벚나무', 22, '보통', 'https://picsum.photos/seed/tree24/400/300', 10, 7, 35.8250000, 127.1491000, now(), now()),
       (13, '은행나무', 50, '양호', 'https://picsum.photos/seed/tree25/400/300', 20, 13, 36.6357000, 127.4917000, now(),
        now()),
       (13, '참나무', 33, '양호', 'https://picsum.photos/seed/tree26/400/300', 16, 10, 36.6365000, 127.4923000, now(),
        now()),
       (14, '단풍나무', 17, '불량', 'https://picsum.photos/seed/tree27/400/300', 7, 4, 35.2281000, 128.6811000, now(), now()),
       (14, '소나무', 36, '양호', 'https://picsum.photos/seed/tree28/400/300', 15, 9, 35.2290000, 128.6824000, now(), now()),
       (15, '자작나무', 20, '양호', 'https://picsum.photos/seed/tree29/400/300', 11, 6, 37.8854000, 127.7298000, now(),
        now()),
       (15, '느티나무', 48, '보통', 'https://picsum.photos/seed/tree30/400/300', 19, 12, 37.8861000, 127.7312000, now(),
        now()),
       (16, '향나무', 25, '양호', 'https://picsum.photos/seed/tree31/400/300', 10, 7, 34.9506000, 127.4872000, now(), now()),
       (16, '편백', 28, '양호', 'https://picsum.photos/seed/tree32/400/300', 13, 6, 34.9514000, 127.4881000, now(), now()),
       (17, '소나무', 31, '보통', 'https://picsum.photos/seed/tree33/400/300', 12, 8, 37.6584000, 126.8320000, now(), now()),
       (17, '참나무', 38, '양호', 'https://picsum.photos/seed/tree34/400/300', 17, 11, 37.6591000, 126.8335000, now(),
        now()),
       (18, '벚나무', 19, '양호', 'https://picsum.photos/seed/tree35/400/300', 9, 6, 36.8151000, 127.1139000, now(), now()),
       (18, '은행나무', 42, '보통', 'https://picsum.photos/seed/tree36/400/300', 17, 11, 36.8163000, 127.1147000, now(),
        now()),
       (19, '느티나무', 62, '양호', 'https://picsum.photos/seed/tree37/400/300', 23, 16, 35.9677000, 126.7369000, now(),
        now()),
       (19, '단풍나무', 21, '양호', 'https://picsum.photos/seed/tree38/400/300', 10, 6, 35.9685000, 126.7380000, now(),
        now()),
       (20, '메타세쿼이아', 37, '양호', 'https://picsum.photos/seed/tree39/400/300', 22, 7, 36.9921000, 127.1128000, now(),
        now()),
       (20, '소나무', 26, '불량', 'https://picsum.photos/seed/tree40/400/300', 11, 7, 36.9932000, 127.1140000, now(), now());
-- ================================= 탄소흡수량 계산 테이블 (tree_coefficient) =================================
-- 상대생장식: W = factorA × (DBH² × H)^factorB
-- 수령추정: age = DBH / annualGrowth
-- 탄소: CO₂(kg) = W × (1+rootRatio) × woodDensity × (44/12)

INSERT INTO tree_coefficient (tree_type, factora, factorb, annual_growth, root_ratio, wood_density)
VALUES ('침엽수', 0.0750, 0.9300, 0.6, 0.25, 0.45);
INSERT INTO tree_coefficient (tree_type, factora, factorb, annual_growth, root_ratio, wood_density)
VALUES ('활엽수', 0.1300, 0.8800, 0.8, 0.25, 0.68);