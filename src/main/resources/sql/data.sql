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
        '010-4456-7812', 'seo_jun@greenfarm.kr', '전라남도 나주시 빛가람로 661', 0, 0, now(), now()),
       (4, 8, 'smart_logic_lab', '$2b$12$oD9n6kltZn7o1jx42UTMV.tW39iCAfbLZYD55zojMmKjQcR3530G.', '최하은', '010-5567-1123',
        'haeun.choi@smartlogic.io', '서울특별시 구로구 디지털로 300', 1, 0, now(), now()),
       (5, 8, 'global_logis_sys', '$2b$12$GjE1DXPbN0Rewnw48kAMUeVHi8dqbs.DwLUGXljO49CO9S4atSQ9e', '정민호',
        '010-9901-2234', 'mh.jung@globallogis.net', '부산광역시 강서구 녹산산단 382로 14번길 55', 1, 0, now(), now()),
       (6, 5, 'future_mob_dev', '$2b$12$2wyWMuTCcev4F8vK2eXWWeOH15bWdG5G7heAI0P94o84oMsHwyqnO', '강지안', '010-3345-6678',
        'jian.kang@futuremob.co.kr', '경기도 화성시 삼성전자로 1', 1, 0, now(), now()),
       (7, 4, 'creative_ads_kr', '$2b$12$/Fm2MH/0m72OWcawU99xYO0wkIL1E/3hfygLbH9UF1zRUHHoNoJcy', '윤소희', '010-7788-9901',
        'sh.yoon@creativeads.com', '서울특별시 마포구 양화로 161', 0, 0, now(), now()),
       (8, 18, 'health_care_plus', '$2b$12$3CVA8FiSqXsK1tctusmVB.MNT1mFQZP/pUztkdS/BEJwiKSelpjIm', '한준영',
        '010-2211-4433', 'jy.han@healthcareplus.kr', '대구광역시 중구 달구벌대로 2077', 1, 0, now(), now()),
       (9, 3, 'urban_design_st', '$2b$12$nyQ/DHK3oxcxlcZqp9Hh0Os7i0/CHn.V8p9X/w7w89AFXKoV2eOrm', '송미경', '010-6655-1100',
        'mk.song@urbandesign.co.kr', '서울특별시 성동구 성수이로 113', 1, 0, now(), now()),
       (10, 19, 'mega_store_dist', '$2b$12$WHmlmkL1Q/DpRDpkpJGnNOTI1zfqV6SL2hvlNmioL4kD1Cx2dUxt2', '임재상',
        '010-4499-8822', 'js.lim@megastore.co.kr', '인천광역시 부평구 부평대로 69', 1, 0, now(), now()),
       (11, 14, 'cloud_infra_sol', '$2b$12$jK.Lt0/ccdbhvPe3yo.7U.vEZ3kjf4NnpymKRYEraPTzTWA7TH95O', '박준영',
        '010-3388-1122', 'jy.park@cloudinfra.co.kr', '서울특별시 서초구 서초대로 301', 0, 0, now(), now()),
       (12, 2, 'neo_medical_kr', '$2b$12$9S0KE7OZEK1VXU8JDiHhqetKid9ALxbMIUu5xa/vE7CD5I.DBuHlO', '이서연', '010-7744-8899',
        'sy.lee@neomed.kr', '경기도 수원시 영통구 광교중앙로 140', 1, 0, now(), now()),
       (13, 1, 'atlas_heavy_ind', '$2b$12$aYk4tkfH7VYB6pXDUsh8qeqOLU63LdAH8vSKeQiPzzukbl6f29Kp6', '최동현',
        '010-2211-5544', 'dh.choi@atlasind.com', '울산광역시 동구 방어진순환도로 1000', 1, 0, now(), now()),
       (14, 3, 'vision_it_group', '$2b$12$pfRbPDBsoQoHvmkP4n0aAu0q7McZhStUQt2likCj0YGES0iUMomVa', '김민지',
        '010-4455-2233', 'mj.kim@visionit.io', '서울특별시 금천구 가산디지털1로 168', 1, 0, now(), now()),
       (15, 7, 'k_logistics_net', '$2b$12$7dN/O6tBHe4zm2aOBR412uw51uTKhP/aDqQ/jy5.gU0UAMByOK3fa', '정태우',
        '010-9988-7766', 'tw.jung@klogis.net', '인천광역시 중구 공항동로 295', 1, 0, now(), now()),
       (16, 8, 'urban_re_mgt', '$2b$12$2fNrxcVvgmgeILczuTJfM.Dp9uBkoexJeQCD.JywQdrt9Fl3v4oFK', '황수진', '010-1133-4422',
        'sj.hwang@urbanmgt.co.kr', '서울특별시 종로구 율곡로 6', 1, 0, now(), now()),
       (17, 17, 'eco_power_tech', '$2b$12$JYQLo0cN1xdtlXTq736bse2rl8gXq593rqXswr83RYPrZnT6v.5Bu', '안재현',
        '010-5566-3311', 'jh.ahn@ecopower.kr', '전라남도 나주시 전력로 55', 1, 0, now(), now()),
       (18, 20, 'global_edu_plus', '$2b$12$.yYKJ6N8iAiXQubn2sSdseeCyEF7auTFosFkCtwGhWLn/PoAvgjHW', '윤하은',
        '010-8811-9922', 'he.yoon@eduplus.com', '서울특별시 강남구 역삼로 415', 1, 0, now(), now()),
       (19, 1, 'smart_iot_lab', '$2b$12$78ZIBwoR9EjnReyCbHS/Fu9Z2Yn4EU2GfJgLvJRAqqHU8S2NrVG7y', '박성민', '010-2244-6688',
        'sm.park@smartiot.io', '경기도 성남시 수정구 창업로 42', 1, 0, now(), now()),
       (20, 18, 'prime_food_sys', '$2b$12$zIaarbB2t4z0q9myCXGqqu6YC.n/ZDhz97S1nBzDIw/980d.ABnRy', '강도윤',
        '010-7799-1155', 'dy.kang@primefood.co.kr', '충청북도 음성군 맹동면 두성리 1500', 1, 0, now(), now()),
-- 관리자 계정 (비밀번호: admin1234)
       (21, 1, 'admin', '$2a$10$QKOodDK/.2WN1r0xFkClzOsD.TrB8oKxRggSGFPAVmqALGqcn07zS', '관리자', '010-0000-0000',
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
INSERT INTO application (member_id, expert_id, times, survey_status, content,
                         due_start_date, due_end_date, create_date, update_date)
VALUES (1, 1, 0, '완료', '여수 공장 견적 확인 요청', '2026-04-01 00:00:00', '2026-04-03 00:00:00', NOW(), NOW()),
       (2, 2, 0, '완료', '소나무 150 그루 초기 답사', '2026-04-01', '2026-04-15', NOW(), NOW()),
       (3, 3, 0, '완료', '지점 견적 확인 요청', '2026-03-05', '2026-03-08', NOW(), NOW()),
       (4, 4, 0, '완료', '참나무 300 그루 수량 파악', '2026-04-11', '2026-04-15', NOW(), NOW()),
       (5, 5, 2, '완료', '탄소 배출권 견적 요청', '2026-04-12', '2026-04-16', NOW(), NOW()),
       (7, 7, 0, '완료', '시설 안전 답사 요청', '2026-04-12', '2026-04-16', NOW(), NOW()),
       (8, 8, 1, '완료', '신규 지점 견적 확인 요청', '2026-04-13', '2026-04-17', NOW(), NOW()),
       (9, 9, 0, '완료', '느티나무 100 그루 초기 답사', '2026-03-10', '2026-03-14', NOW(), NOW()),
       (10, 10, 0, '완료', '지사 견적 확인 요청', '2026-04-13', '2026-04-17', NOW(), NOW()),
       (1, 11, 1, '완료', '마포 인근 견적 확인 요청', '2026-04-14', '2026-04-18', NOW(), NOW()),
       (2, 12, 1, '완료', '편백나무 250 그루 수량 파악', '2026-04-14', '2026-04-18', NOW(), NOW()),
       (3, 13, 1, '완료', '대구 인근 견적 확인 요청', '2026-03-12', '2026-03-16', NOW(), NOW()),
       (4, 14, 1, '완료', '은행나무 80 그루 초기 답사', '2026-03-15', '2026-03-19', NOW(), NOW()),
       (5, 15, 3, '신청', '설비 교체 견적 요청', '2026-04-15', '2026-04-20', NOW(), NOW()),
       (6, 1, 0, '완료', '나주 공장 견적 확인 요청', '2026-03-20', '2026-03-23', NOW(), NOW()),
       (7, 16, 1, '완료', '단풍나무 120 그루 상태 확인', '2026-04-16', '2026-04-20', NOW(), NOW()),
       (8, 17, 2, '완료', '과천 지역 견적 확인 요청', '2026-04-16', '2026-04-20', NOW(), NOW()),
       (9, 18, 1, '완료', '판교 지사 견적 확인 요청', '2026-03-22', '2026-03-26', NOW(), NOW()),
       (10, 19, 1, '완료', '감귤나무 400 그루 초기 답사', '2026-04-17', '2026-04-21', NOW(), NOW()),
       (1, 20, 2, '완료', '평택 공장 견적 확인 요청', '2026-04-18', '2026-04-22', NOW(), NOW()),
       (2, 21, 2, '완료', '잣나무 200 그루 수량 파악', '2026-03-25', '2026-03-29', NOW(), NOW()),
       (3, 22, 3, '진행중', '당진 공장 견적 확인 요청', '2026-04-18', '2026-04-22', NOW(), NOW()),
       (4, 23, 2, '완료', '원주 지점 견적 확인 요청', '2026-04-19', '2026-04-23', NOW(), NOW()),
       (5, 24, 0, '완료', '배나무 300 그루 초기 답사', '2026-03-28', '2026-04-01', NOW(), NOW()),
       (6, 25, 1, '완료', '익산 지사 견적 확인 요청', '2026-04-19', '2026-04-23', NOW(), NOW()),
       (7, 26, 2, '완료', '주목 150 그루 상태 확인', '2026-04-20', '2026-04-24', NOW(), NOW()),
       (8, 27, 3, '진행중', '포항 공장 견적 확인 요청', '2026-04-20', '2026-04-24', NOW(), NOW()),
       (9, 28, 2, '완료', '창원 지점 견적 확인 요청', '2026-04-21', '2026-04-25', NOW(), NOW()),
       (10, 29, 2, '완료', '측백나무 200 그루 수량 파악', '2026-03-01', '2026-03-05', NOW(), NOW()),
       (1, 30, 3, '진행중', '진주 지점 견적 확인 요청', '2026-04-21', '2026-04-25', NOW(), NOW()),
       (2, 31, 3, '신청', '소나무 350 그루 초기 답사', '2026-04-22', '2026-04-26', NOW(), NOW()),
       (3, 32, 2, '완료', '천안 지점 견적 확인 요청', '2026-03-02', '2026-03-06', NOW(), NOW()),
       (4, 33, 3, '진행중', '성남 지점 견적 확인 요청', '2026-04-22', '2026-04-26', NOW(), NOW()),
       (5, 34, 1, '완료', '상수리나무 100 그루 초기 답사', '2026-03-03', '2026-03-07', NOW(), NOW()),
       (6, 35, 2, '신청', '용인 지사 견적 확인 요청', '2026-04-23', '2026-04-27', NOW(), NOW()),
       (7, 1, 3, '진행중', '전나무 180 그루 수량 파악', '2026-04-23', '2026-04-27', NOW(), NOW()),
       (8, 2, 0, '완료', '군포 지점 견적 확인 요청', '2026-03-04', '2026-03-08', NOW(), NOW()),
       (9, 3, 3, '신청', '가문비나무 220 그루 초기 답사', '2026-04-24', '2026-04-28', NOW(), NOW()),
       (10, 4, 3, '진행중', '김포 공장 견적 확인 요청', '2026-04-24', '2026-04-28', NOW(), NOW());
-- ================================= 답사정보 샘플 코드  =================================
insert into expert_report
(detail_id, tree_type, dbh, tree_status, picture, height, width, latitude, longitude, kind, create_date, update_date)
VALUES
    (1, '소나무', 21, '양호', 'https://picsum.photos/seed/tree1/400/300', 9, 6, 37.503560, 127.044640, '침엽수', now(), now()),
    (1, '은행나무', 26, '양호', 'https://picsum.photos/seed/tree2/400/300', 10, 7, 37.503580, 127.044570, '활엽수', now(), now()),
    (1, '단풍나무', 31, '보통', 'https://picsum.photos/seed/tree3/400/300', 11, 8, 37.503450, 127.044660, '활엽수', now(), now()),
    (1, '느티나무', 36, '양호', 'https://picsum.photos/seed/tree4/400/300', 12, 9, 37.503430, 127.044560, '활엽수', now(), now()),
    (1, '메타세쿼이아', 41, '불량', 'https://picsum.photos/seed/tree5/400/300', 13, 10, 37.503510, 127.044690, '침엽수', now(), now()),

    (2, '은행나무', 24, '양호', 'https://picsum.photos/seed/tree6/400/300', 10, 8, 37.395360, 127.111240, '활엽수', now(), now()),
    (2, '단풍나무', 29, '양호', 'https://picsum.photos/seed/tree7/400/300', 11, 9, 37.395380, 127.111170, '활엽수', now(), now()),
    (2, '느티나무', 34, '보통', 'https://picsum.photos/seed/tree8/400/300', 12, 10, 37.395250, 127.111260, '활엽수', now(), now()),
    (2, '메타세쿼이아', 39, '양호', 'https://picsum.photos/seed/tree9/400/300', 13, 11, 37.395230, 127.111160, '침엽수', now(), now()),
    (2, '벚나무', 44, '불량', 'https://picsum.photos/seed/tree10/400/300', 14, 12, 37.395310, 127.111290, '활엽수', now(), now()),

    (3, '단풍나무', 27, '양호', 'https://picsum.photos/seed/tree11/400/300', 11, 10, 35.016760, 126.790540, '활엽수', now(), now()),
    (3, '느티나무', 32, '양호', 'https://picsum.photos/seed/tree12/400/300', 12, 11, 35.016780, 126.790470, '활엽수', now(), now()),
    (3, '메타세쿼이아', 37, '보통', 'https://picsum.photos/seed/tree13/400/300', 13, 12, 35.016650, 126.790560, '침엽수', now(), now()),
    (3, '벚나무', 42, '양호', 'https://picsum.photos/seed/tree14/400/300', 14, 13, 35.016630, 126.790460, '활엽수', now(), now()),
    (3, '향나무', 47, '불량', 'https://picsum.photos/seed/tree15/400/300', 15, 4, 35.016710, 126.790590, '침엽수', now(), now()),

    (4, '느티나무', 30, '양호', 'https://picsum.photos/seed/tree16/400/300', 12, 12, 37.484960, 126.896640, '활엽수', now(), now()),
    (4, '메타세쿼이아', 35, '양호', 'https://picsum.photos/seed/tree17/400/300', 13, 13, 37.484980, 126.896570, '침엽수', now(), now()),
    (4, '벚나무', 40, '보통', 'https://picsum.photos/seed/tree18/400/300', 14, 4, 37.484850, 126.896660, '활엽수', now(), now()),
    (4, '향나무', 45, '양호', 'https://picsum.photos/seed/tree19/400/300', 15, 5, 37.484830, 126.896560, '침엽수', now(), now()),
    (4, '참나무', 50, '불량', 'https://picsum.photos/seed/tree20/400/300', 16, 6, 37.484910, 126.896690, '활엽수', now(), now()),

    (5, '메타세쿼이아', 33, '양호', 'https://picsum.photos/seed/tree21/400/300', 13, 4, 35.095260, 128.832840, '침엽수', now(), now()),
    (5, '벚나무', 38, '양호', 'https://picsum.photos/seed/tree22/400/300', 14, 5, 35.095280, 128.832770, '활엽수', now(), now()),
    (5, '향나무', 43, '보통', 'https://picsum.photos/seed/tree23/400/300', 15, 6, 35.095150, 128.832860, '침엽수', now(), now()),
    (5, '참나무', 48, '양호', 'https://picsum.photos/seed/tree24/400/300', 16, 7, 35.095130, 128.832760, '활엽수', now(), now()),
    (5, '편백', 53, '불량', 'https://picsum.photos/seed/tree25/400/300', 17, 8, 35.095210, 128.832890, '침엽수', now(), now()),

    (6, '벚나무', 36, '양호', 'https://picsum.photos/seed/tree26/400/300', 14, 6, 37.221960, 127.070740, '활엽수', now(), now()),
    (6, '향나무', 41, '양호', 'https://picsum.photos/seed/tree27/400/300', 15, 7, 37.221980, 127.070670, '침엽수', now(), now()),
    (6, '참나무', 46, '보통', 'https://picsum.photos/seed/tree28/400/300', 16, 8, 37.221850, 127.070760, '활엽수', now(), now()),
    (6, '편백', 51, '양호', 'https://picsum.photos/seed/tree29/400/300', 17, 9, 37.221830, 127.070660, '침엽수', now(), now()),
    (6, '자작나무', 18, '불량', 'https://picsum.photos/seed/tree30/400/300', 18, 10, 37.221910, 127.070790, '활엽수', now(), now()),

    (7, '향나무', 39, '양호', 'https://picsum.photos/seed/tree31/400/300', 15, 8, 37.557460, 126.924540, '침엽수', now(), now()),
    (7, '참나무', 44, '양호', 'https://picsum.photos/seed/tree32/400/300', 16, 9, 37.557480, 126.924470, '활엽수', now(), now()),
    (7, '편백', 49, '보통', 'https://picsum.photos/seed/tree33/400/300', 17, 10, 37.557350, 126.924560, '침엽수', now(), now()),
    (7, '자작나무', 54, '양호', 'https://picsum.photos/seed/tree34/400/300', 18, 11, 37.557330, 126.924460, '활엽수', now(), now()),
    (7, '소나무', 21, '불량', 'https://picsum.photos/seed/tree35/400/300', 19, 12, 37.557410, 126.924590, '침엽수', now(), now()),

    (8, '참나무', 42, '양호', 'https://picsum.photos/seed/tree36/400/300', 16, 10, 35.869760, 128.593740, '활엽수', now(), now()),
    (8, '편백', 47, '양호', 'https://picsum.photos/seed/tree37/400/300', 17, 11, 35.869780, 128.593670, '침엽수', now(), now()),
    (8, '자작나무', 52, '보통', 'https://picsum.photos/seed/tree38/400/300', 18, 12, 35.869650, 128.593760, '활엽수', now(), now()),
    (8, '소나무', 19, '양호', 'https://picsum.photos/seed/tree39/400/300', 19, 13, 35.869630, 128.593660, '침엽수', now(), now()),
    (8, '은행나무', 24, '불량', 'https://picsum.photos/seed/tree40/400/300', 20, 4, 35.869710, 128.593790, '활엽수', now(), now()),

    (9, '편백', 45, '양호', 'https://picsum.photos/seed/tree41/400/300', 17, 12, 37.545560, 127.056940, '침엽수', now(), now()),
    (9, '자작나무', 50, '양호', 'https://picsum.photos/seed/tree42/400/300', 18, 13, 37.545580, 127.056870, '활엽수', now(), now()),
    (9, '소나무', 55, '보통', 'https://picsum.photos/seed/tree43/400/300', 19, 4, 37.545450, 127.056960, '침엽수', now(), now()),
    (9, '은행나무', 22, '양호', 'https://picsum.photos/seed/tree44/400/300', 20, 5, 37.545430, 127.056860, '활엽수', now(), now()),
    (9, '단풍나무', 27, '불량', 'https://picsum.photos/seed/tree45/400/300', 21, 6, 37.545510, 127.056990, '활엽수', now(), now()),

    (10, '자작나무', 48, '양호', 'https://picsum.photos/seed/tree46/400/300', 18, 4, 37.507860, 126.721940, '활엽수', now(), now()),
    (10, '소나무', 53, '양호', 'https://picsum.photos/seed/tree47/400/300', 19, 5, 37.507880, 126.721870, '침엽수', now(), now()),
    (10, '은행나무', 20, '보통', 'https://picsum.photos/seed/tree48/400/300', 20, 6, 37.507750, 126.721960, '활엽수', now(), now()),
    (10, '단풍나무', 25, '양호', 'https://picsum.photos/seed/tree49/400/300', 21, 7, 37.507730, 126.721860, '활엽수', now(), now()),
    (10, '느티나무', 30, '불량', 'https://picsum.photos/seed/tree50/400/300', 22, 8, 37.507810, 126.721990, '활엽수', now(), now()),

    (11, '소나무', 51, '양호', 'https://picsum.photos/seed/tree51/400/300', 19, 6, 37.491460, 127.008740, '침엽수', now(), now()),
    (11, '은행나무', 18, '양호', 'https://picsum.photos/seed/tree52/400/300', 20, 7, 37.491480, 127.008670, '활엽수', now(), now()),
    (11, '단풍나무', 23, '보통', 'https://picsum.photos/seed/tree53/400/300', 21, 8, 37.491350, 127.008760, '활엽수', now(), now()),
    (11, '느티나무', 28, '양호', 'https://picsum.photos/seed/tree54/400/300', 22, 9, 37.491330, 127.008660, '활엽수', now(), now()),
    (11, '메타세쿼이아', 33, '불량', 'https://picsum.photos/seed/tree55/400/300', 23, 10, 37.491410, 127.008790, '침엽수', now(), now()),

    (12, '은행나무', 54, '양호', 'https://picsum.photos/seed/tree56/400/300', 20, 8, 37.286160, 127.057740, '활엽수', now(), now()),
    (12, '단풍나무', 21, '양호', 'https://picsum.photos/seed/tree57/400/300', 21, 9, 37.286180, 127.057670, '활엽수', now(), now()),
    (12, '느티나무', 26, '보통', 'https://picsum.photos/seed/tree58/400/300', 22, 10, 37.286050, 127.057760, '활엽수', now(), now()),
    (12, '메타세쿼이아', 31, '양호', 'https://picsum.photos/seed/tree59/400/300', 23, 11, 37.286030, 127.057660, '침엽수', now(), now()),
    (12, '벚나무', 36, '불량', 'https://picsum.photos/seed/tree60/400/300', 24, 12, 37.286110, 127.057790, '활엽수', now(), now()),

    (13, '단풍나무', 19, '양호', 'https://picsum.photos/seed/tree61/400/300', 21, 10, 35.517260, 129.430840, '활엽수', now(), now()),
    (13, '느티나무', 24, '양호', 'https://picsum.photos/seed/tree62/400/300', 22, 11, 35.517280, 129.430770, '활엽수', now(), now()),
    (13, '메타세쿼이아', 29, '보통', 'https://picsum.photos/seed/tree63/400/300', 23, 12, 35.517150, 129.430860, '침엽수', now(), now()),
    (13, '벚나무', 34, '양호', 'https://picsum.photos/seed/tree64/400/300', 24, 13, 35.517130, 129.430760, '활엽수', now(), now()),
    (13, '향나무', 39, '불량', 'https://picsum.photos/seed/tree65/400/300', 8, 4, 35.517210, 129.430890, '침엽수', now(), now()),

    (14, '느티나무', 22, '양호', 'https://picsum.photos/seed/tree66/400/300', 22, 12, 37.479560, 126.889540, '활엽수', now(), now()),
    (14, '메타세쿼이아', 27, '양호', 'https://picsum.photos/seed/tree67/400/300', 23, 13, 37.479580, 126.889470, '침엽수', now(), now()),
    (14, '벚나무', 32, '보통', 'https://picsum.photos/seed/tree68/400/300', 24, 4, 37.479450, 126.889560, '활엽수', now(), now()),
    (14, '향나무', 37, '양호', 'https://picsum.photos/seed/tree69/400/300', 8, 5, 37.479430, 126.889460, '침엽수', now(), now()),
    (14, '참나무', 42, '불량', 'https://picsum.photos/seed/tree70/400/300', 9, 6, 37.479510, 126.889590, '활엽수', now(), now()),

    (16, '벚나무', 28, '양호', 'https://picsum.photos/seed/tree76/400/300', 24, 6, 37.575960, 126.980040, '활엽수', now(), now()),
    (16, '향나무', 33, '양호', 'https://picsum.photos/seed/tree77/400/300', 8, 7, 37.575980, 126.979970, '침엽수', now(), now()),
    (16, '참나무', 38, '보통', 'https://picsum.photos/seed/tree78/400/300', 9, 8, 37.575850, 126.980060, '활엽수', now(), now()),
    (16, '편백', 43, '양호', 'https://picsum.photos/seed/tree79/400/300', 10, 9, 37.575830, 126.979960, '침엽수', now(), now()),
    (16, '자작나무', 48, '불량', 'https://picsum.photos/seed/tree80/400/300', 11, 10, 37.575910, 126.980090, '활엽수', now(), now()),

    (17, '향나무', 31, '양호', 'https://picsum.photos/seed/tree81/400/300', 8, 8, 35.016160, 126.789140, '침엽수', now(), now()),
    (17, '참나무', 36, '양호', 'https://picsum.photos/seed/tree82/400/300', 9, 9, 35.016180, 126.789070, '활엽수', now(), now()),
    (17, '편백', 41, '보통', 'https://picsum.photos/seed/tree83/400/300', 10, 10, 35.016050, 126.789160, '침엽수', now(), now()),
    (17, '자작나무', 46, '양호', 'https://picsum.photos/seed/tree84/400/300', 11, 11, 35.016030, 126.789060, '활엽수', now(), now()),
    (17, '소나무', 51, '불량', 'https://picsum.photos/seed/tree85/400/300', 12, 12, 35.016110, 126.789190, '침엽수', now(), now()),

    (18, '참나무', 34, '양호', 'https://picsum.photos/seed/tree86/400/300', 9, 10, 37.499860, 127.049140, '활엽수', now(), now()),
    (18, '편백', 39, '양호', 'https://picsum.photos/seed/tree87/400/300', 10, 11, 37.499880, 127.049070, '침엽수', now(), now()),
    (18, '자작나무', 44, '보통', 'https://picsum.photos/seed/tree88/400/300', 11, 12, 37.499750, 127.049160, '활엽수', now(), now()),
    (18, '소나무', 49, '양호', 'https://picsum.photos/seed/tree89/400/300', 12, 13, 37.499730, 127.049060, '침엽수', now(), now()),
    (18, '은행나무', 54, '불량', 'https://picsum.photos/seed/tree90/400/300', 13, 4, 37.499810, 127.049190, '활엽수', now(), now()),

    (19, '편백', 37, '양호', 'https://picsum.photos/seed/tree91/400/300', 10, 12, 37.402960, 127.104540, '침엽수', now(), now()),
    (19, '자작나무', 42, '양호', 'https://picsum.photos/seed/tree92/400/300', 11, 13, 37.402980, 127.104470, '활엽수', now(), now()),
    (19, '소나무', 47, '보통', 'https://picsum.photos/seed/tree93/400/300', 12, 4, 37.402850, 127.104560, '침엽수', now(), now()),
    (19, '은행나무', 52, '양호', 'https://picsum.photos/seed/tree94/400/300', 13, 5, 37.402830, 127.104460, '활엽수', now(), now()),
    (19, '단풍나무', 19, '불량', 'https://picsum.photos/seed/tree95/400/300', 14, 6, 37.402910, 127.104590, '활엽수', now(), now()),

    (20, '자작나무', 40, '양호', 'https://picsum.photos/seed/tree96/400/300', 11, 4, 36.948460, 127.437840, '활엽수', now(), now()),
    (20, '소나무', 45, '양호', 'https://picsum.photos/seed/tree97/400/300', 12, 5, 36.948480, 127.437770, '침엽수', now(), now()),
    (20, '은행나무', 50, '보통', 'https://picsum.photos/seed/tree98/400/300', 13, 6, 36.948350, 127.437860, '활엽수', now(), now()),
    (20, '단풍나무', 55, '양호', 'https://picsum.photos/seed/tree99/400/300', 14, 7, 36.948330, 127.437760, '활엽수', now(), now()),
    (20, '느티나무', 22, '불량', 'https://picsum.photos/seed/tree100/400/300', 15, 8, 36.948410, 127.437890, '활엽수', now(), now()),

    (21, '소나무', 21, '양호', 'https://picsum.photos/seed/tree21_1/400/300', 9, 6, 37.503560, 127.044640, '침엽수', now(), now()),
    (21, '은행나무', 26, '양호', 'https://picsum.photos/seed/tree21_2/400/300', 10, 7, 37.503580, 127.044570, '활엽수', now(), now()),
    (21, '단풍나무', 31, '보통', 'https://picsum.photos/seed/tree21_3/400/300', 11, 8, 37.503450, 127.044660, '활엽수', now(), now()),
    (21, '느티나무', 36, '양호', 'https://picsum.photos/seed/tree21_4/400/300', 12, 9, 37.503430, 127.044560, '활엽수', now(), now()),
    (21, '메타세쿼이아', 41, '불량', 'https://picsum.photos/seed/tree21_5/400/300', 13, 10, 37.503510, 127.044690, '침엽수', now(), now()),
    (21, '자작나무', 23, '보통', 'https://picsum.photos/seed/tree21_6/400/300', 8, 5, 37.503520, 127.044600, '활엽수', now(), now()),

-- detail_id = 22
    (22, '소나무', 21, '양호', 'https://picsum.photos/seed/tree22_1/400/300', 9, 6, 37.503560, 127.044640, '침엽수', now(), now()),
    (22, '은행나무', 26, '양호', 'https://picsum.photos/seed/tree22_2/400/300', 10, 7, 37.503580, 127.044570, '활엽수', now(), now()),
    (22, '단풍나무', 31, '보통', 'https://picsum.photos/seed/tree22_3/400/300', 11, 8, 37.503450, 127.044660, '활엽수', now(), now()),
    (22, '느티나무', 36, '양호', 'https://picsum.photos/seed/tree22_4/400/300', 12, 9, 37.503430, 127.044560, '활엽수', now(), now()),
    (22, '메타세쿼이아', 41, '불량', 'https://picsum.photos/seed/tree22_5/400/300', 13, 10, 37.503510, 127.044690, '침엽수', now(), now()),
    (22, '자작나무', 23, '보통', 'https://picsum.photos/seed/tree22_6/400/300', 8, 5, 37.503520, 127.044600, '활엽수', now(), now()),

-- detail_id = 24
    (24, '소나무', 21, '양호', 'https://picsum.photos/seed/tree24_1/400/300', 9, 6, 37.503560, 127.044640, '침엽수', now(), now()),
    (24, '은행나무', 26, '양호', 'https://picsum.photos/seed/tree24_2/400/300', 10, 7, 37.503580, 127.044570, '활엽수', now(), now()),
    (24, '단풍나무', 31, '보통', 'https://picsum.photos/seed/tree24_3/400/300', 11, 8, 37.503450, 127.044660, '활엽수', now(), now()),
    (24, '느티나무', 36, '양호', 'https://picsum.photos/seed/tree24_4/400/300', 12, 9, 37.503430, 127.044560, '활엽수', now(), now()),
    (24, '메타세쿼이아', 41, '불량', 'https://picsum.photos/seed/tree24_5/400/300', 13, 10, 37.503510, 127.044690, '침엽수', now(), now()),
    (24, '자작나무', 23, '보통', 'https://picsum.photos/seed/tree24_6/400/300', 8, 5, 37.503520, 127.044600, '활엽수', now(), now()),

-- detail_id = 25
    (25, '소나무', 21, '양호', 'https://picsum.photos/seed/tree25_1/400/300', 9, 6, 37.503560, 127.044640, '침엽수', now(), now()),
    (25, '은행나무', 26, '양호', 'https://picsum.photos/seed/tree25_2/400/300', 10, 7, 37.503580, 127.044570, '활엽수', now(), now()),
    (25, '단풍나무', 31, '보통', 'https://picsum.photos/seed/tree25_3/400/300', 11, 8, 37.503450, 127.044660, '활엽수', now(), now()),
    (25, '느티나무', 36, '양호', 'https://picsum.photos/seed/tree25_4/400/300', 12, 9, 37.503430, 127.044560, '활엽수', now(), now()),
    (25, '메타세쿼이아', 41, '불량', 'https://picsum.photos/seed/tree25_5/400/300', 13, 10, 37.503510, 127.044690, '침엽수', now(), now()),
    (25, '자작나무', 23, '보통', 'https://picsum.photos/seed/tree25_6/400/300', 8, 5, 37.503520, 127.044600, '활엽수', now(), now()),

-- detail_id = 26
    (26, '소나무', 21, '양호', 'https://picsum.photos/seed/tree26_1/400/300', 9, 6, 37.503560, 127.044640, '침엽수', now(), now()),
    (26, '은행나무', 26, '양호', 'https://picsum.photos/seed/tree26_2/400/300', 10, 7, 37.503580, 127.044570, '활엽수', now(), now()),
    (26, '단풍나무', 31, '보통', 'https://picsum.photos/seed/tree26_3/400/300', 11, 8, 37.503450, 127.044660, '활엽수', now(), now()),
    (26, '느티나무', 36, '양호', 'https://picsum.photos/seed/tree26_4/400/300', 12, 9, 37.503430, 127.044560, '활엽수', now(), now()),
    (26, '메타세쿼이아', 41, '불량', 'https://picsum.photos/seed/tree26_5/400/300', 13, 10, 37.503510, 127.044690, '침엽수', now(), now()),
    (26, '자작나무', 23, '보통', 'https://picsum.photos/seed/tree26_6/400/300', 8, 5, 37.503520, 127.044600, '활엽수', now(), now()),

-- detail_id = 27
    (27, '소나무', 21, '양호', 'https://picsum.photos/seed/tree27_1/400/300', 9, 6, 37.503560, 127.044640, '침엽수', now(), now()),
    (27, '은행나무', 26, '양호', 'https://picsum.photos/seed/tree27_2/400/300', 10, 7, 37.503580, 127.044570, '활엽수', now(), now()),
    (27, '단풍나무', 31, '보통', 'https://picsum.photos/seed/tree27_3/400/300', 11, 8, 37.503450, 127.044660, '활엽수', now(), now()),
    (27, '느티나무', 36, '양호', 'https://picsum.photos/seed/tree27_4/400/300', 12, 9, 37.503430, 127.044560, '활엽수', now(), now()),
    (27, '메타세쿼이아', 41, '불량', 'https://picsum.photos/seed/tree27_5/400/300', 13, 10, 37.503510, 127.044690, '침엽수', now(), now()),
    (27, '자작나무', 23, '보통', 'https://picsum.photos/seed/tree27_6/400/300', 8, 5, 37.503520, 127.044600, '활엽수', now(), now()),

    (29, '소나무', 21, '양호', 'https://picsum.photos/seed/tree29_1/400/300', 9, 6, 37.503560, 127.044640, '침엽수', now(), now()),
    (29, '은행나무', 26, '양호', 'https://picsum.photos/seed/tree29_2/400/300', 10, 7, 37.503580, 127.044570, '활엽수', now(), now()),
    (29, '단풍나무', 31, '보통', 'https://picsum.photos/seed/tree29_3/400/300', 11, 8, 37.503450, 127.044660, '활엽수', now(), now()),
    (29, '느티나무', 36, '양호', 'https://picsum.photos/seed/tree29_4/400/300', 12, 9, 37.503430, 127.044560, '활엽수', now(), now()),
    (29, '메타세쿼이아', 41, '불량', 'https://picsum.photos/seed/tree29_5/400/300', 13, 10, 37.503510, 127.044690, '침엽수', now(), now()),
    (29, '자작나무', 23, '보통', 'https://picsum.photos/seed/tree29_6/400/300', 8, 5, 37.503520, 127.044600, '활엽수', now(), now()),

-- detail_id = 30
    (30, '소나무', 21, '양호', 'https://picsum.photos/seed/tree30_1/400/300', 9, 6, 37.503560, 127.044640, '침엽수', now(), now()),
    (30, '은행나무', 26, '양호', 'https://picsum.photos/seed/tree30_2/400/300', 10, 7, 37.503580, 127.044570, '활엽수', now(), now()),
    (30, '단풍나무', 31, '보통', 'https://picsum.photos/seed/tree30_3/400/300', 11, 8, 37.503450, 127.044660, '활엽수', now(), now()),
    (30, '느티나무', 36, '양호', 'https://picsum.photos/seed/tree30_4/400/300', 12, 9, 37.503430, 127.044560, '활엽수', now(), now()),
    (30, '메타세쿼이아', 41, '불량', 'https://picsum.photos/seed/tree30_5/400/300', 13, 10, 37.503510, 127.044690, '침엽수', now(), now()),
    (30, '자작나무', 23, '보통', 'https://picsum.photos/seed/tree30_6/400/300', 8, 5, 37.503520, 127.044600, '활엽수', now(), now()),

-- detail_id = 33
    (33, '소나무', 21, '양호', 'https://picsum.photos/seed/tree33_1/400/300', 9, 6, 37.503560, 127.044640, '침엽수', now(), now()),
    (33, '은행나무', 26, '양호', 'https://picsum.photos/seed/tree33_2/400/300', 10, 7, 37.503580, 127.044570, '활엽수', now(), now()),
    (33, '단풍나무', 31, '보통', 'https://picsum.photos/seed/tree33_3/400/300', 11, 8, 37.503450, 127.044660, '활엽수', now(), now()),
    (33, '느티나무', 36, '양호', 'https://picsum.photos/seed/tree33_4/400/300', 12, 9, 37.503430, 127.044560, '활엽수', now(), now()),
    (33, '메타세쿼이아', 41, '불량', 'https://picsum.photos/seed/tree33_5/400/300', 13, 10, 37.503510, 127.044690, '침엽수', now(), now()),
    (33, '자작나무', 23, '보통', 'https://picsum.photos/seed/tree33_6/400/300', 8, 5, 37.503520, 127.044600, '활엽수', now(), now()),

-- detail_id = 35
    (35, '소나무', 21, '양호', 'https://picsum.photos/seed/tree35_1/400/300', 9, 6, 37.503560, 127.044640, '침엽수', now(), now()),
    (35, '은행나무', 26, '양호', 'https://picsum.photos/seed/tree35_2/400/300', 10, 7, 37.503580, 127.044570, '활엽수', now(), now()),
    (35, '단풍나무', 31, '보통', 'https://picsum.photos/seed/tree35_3/400/300', 11, 8, 37.503450, 127.044660, '활엽수', now(), now()),
    (35, '느티나무', 36, '양호', 'https://picsum.photos/seed/tree35_4/400/300', 12, 9, 37.503430, 127.044560, '활엽수', now(), now()),
    (35, '메타세쿼이아', 41, '불량', 'https://picsum.photos/seed/tree35_5/400/300', 13, 10, 37.503510, 127.044690, '침엽수', now(), now()),
    (35, '자작나무', 23, '보통', 'https://picsum.photos/seed/tree35_6/400/300', 8, 5, 37.503520, 127.044600, '활엽수', now(), now()),

-- detail_id = 38
    (38, '소나무', 21, '양호', 'https://picsum.photos/seed/tree38_1/400/300', 9, 6, 37.503560, 127.044640, '침엽수', now(), now()),
    (38, '은행나무', 26, '양호', 'https://picsum.photos/seed/tree38_2/400/300', 10, 7, 37.503580, 127.044570, '활엽수', now(), now()),
    (38, '단풍나무', 31, '보통', 'https://picsum.photos/seed/tree38_3/400/300', 11, 8, 37.503450, 127.044660, '활엽수', now(), now()),
    (38, '느티나무', 36, '양호', 'https://picsum.photos/seed/tree38_4/400/300', 12, 9, 37.503430, 127.044560, '활엽수', now(), now()),
    (38, '메타세쿼이아', 41, '불량', 'https://picsum.photos/seed/tree38_5/400/300', 13, 10, 37.503510, 127.044690, '침엽수', now(), now()),
    (38, '자작나무', 23, '보통', 'https://picsum.photos/seed/tree38_6/400/300', 8, 5, 37.503520, 127.044600, '활엽수', now(), now());
-- ================================= 상대생장식 계수 (carbon_coefficient) =================================
-- 탄소현황 계산용: W = factorA × (D²H)^factorB → CO₂ = W × (1+R) × (44/12)
-- 침엽수/활엽수 카테고리별 평균 계수 (22종 평균값)
INSERT INTO carbon_coefficient (tree_type, factora, factorb, annual_growth, root_ratio, wood_density, bef)
VALUES ('침엽수', 0.129, 2.336, 0.55, 0.272, 0.439, 1.444);
INSERT INTO carbon_coefficient (tree_type, factora, factorb, annual_growth, root_ratio, wood_density, bef)
VALUES ('활엽수', 0.180, 2.406, 0.61, 0.341, 0.623, 1.650);

-- ================================= 나무 추천용 22종 (tree_coefficient) =================================
-- 추천 알고리즘용: W = factorA × D^factorB (줄기 바이오매스, kg)
-- 출처: 국립산림과학원(2014) 한국 주요 수종별 탄소배출계수 및 바이오매스 상대생장식
-- D=목재기본밀도, BEF=바이오매스확장계수, R=뿌리함량비

-- 침엽수 8종
-- 컬럼: tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max,
--        preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max,
--        spacing_meter, maintenance_level, aesthetic_score
INSERT INTO tree_coefficient (tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max, preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max, spacing_meter, maintenance_level, aesthetic_score)
VALUES ('강원지방소나무', 'Pinus densiflora', '침엽수', 0.209, 2.087, 0.5, 0.258, 0.419, 1.483, 6, 70, 1, 3, 1, 2, 2, 4, 4.0, 1, 5);
INSERT INTO tree_coefficient (tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max, preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max, spacing_meter, maintenance_level, aesthetic_score)
VALUES ('중부지방소나무', 'Pinus densiflora', '침엽수', 0.235, 2.071, 0.5, 0.254, 0.472, 1.413, 6, 40, 1, 3, 1, 2, 2, 4, 4.0, 1, 5);
INSERT INTO tree_coefficient (tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max, preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max, spacing_meter, maintenance_level, aesthetic_score)
VALUES ('리기다소나무', 'Pinus rigida', '침엽수', 0.220, 2.116, 0.6, 0.362, 0.504, 1.325, 6, 40, 1, 4, 1, 3, 1, 5, 3.0, 1, 2);
INSERT INTO tree_coefficient (tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max, preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max, spacing_meter, maintenance_level, aesthetic_score)
VALUES ('곰솔', 'Pinus thunbergii', '침엽수', 0.081, 2.455, 0.5, 0.290, 0.481, 1.524, 6, 40, 1, 4, 1, 2, 1, 4, 4.0, 1, 4);
INSERT INTO tree_coefficient (tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max, preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max, spacing_meter, maintenance_level, aesthetic_score)
VALUES ('잣나무', 'Pinus koraiensis', '침엽수', 0.064, 2.377, 0.4, 0.283, 0.408, 1.812, 6, 40, 1, 3, 1, 2, 3, 5, 5.0, 2, 4);
INSERT INTO tree_coefficient (tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max, preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max, spacing_meter, maintenance_level, aesthetic_score)
VALUES ('일본잎갈나무', 'Larix kaempferi', '침엽수', 0.016, 2.888, 0.7, 0.291, 0.453, 1.335, 6, 50, 1, 3, 1, 2, 2, 4, 3.0, 1, 3);
INSERT INTO tree_coefficient (tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max, preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max, spacing_meter, maintenance_level, aesthetic_score)
VALUES ('삼나무', 'Cryptomeria japonica', '침엽수', 0.042, 2.533, 0.6, 0.233, 0.347, 1.313, 6, 50, 2, 4, 1, 2, 3, 5, 3.0, 2, 4);
INSERT INTO tree_coefficient (tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max, preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max, spacing_meter, maintenance_level, aesthetic_score)
VALUES ('편백', 'Chamaecyparis obtusa', '침엽수', 0.165, 2.157, 0.5, 0.203, 0.427, 1.349, 6, 50, 1, 3, 1, 2, 3, 5, 3.0, 2, 5);

-- 낙엽활엽수 10종
INSERT INTO tree_coefficient (tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max, preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max, spacing_meter, maintenance_level, aesthetic_score)
VALUES ('상수리나무', 'Quercus acutissima', '낙엽활엽수', 0.051, 2.724, 0.7, 0.313, 0.721, 1.450, 6, 30, 1, 4, 1, 2, 2, 5, 5.0, 1, 3);
INSERT INTO tree_coefficient (tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max, preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max, spacing_meter, maintenance_level, aesthetic_score)
VALUES ('굴참나무', 'Quercus variabilis', '낙엽활엽수', 0.186, 2.184, 0.6, 0.324, 0.721, 1.338, 6, 50, 1, 4, 1, 2, 2, 5, 5.0, 1, 3);
INSERT INTO tree_coefficient (tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max, preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max, spacing_meter, maintenance_level, aesthetic_score)
VALUES ('신갈나무', 'Quercus mongolica', '낙엽활엽수', 0.595, 1.766, 0.6, 0.388, 0.663, 1.603, 6, 40, 1, 3, 1, 2, 3, 5, 5.0, 1, 4);
INSERT INTO tree_coefficient (tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max, preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max, spacing_meter, maintenance_level, aesthetic_score)
VALUES ('졸참나무', 'Quercus serrata', '낙엽활엽수', 0.177, 2.195, 0.5, 0.438, 0.658, 1.566, 6, 30, 1, 3, 1, 2, 3, 5, 4.0, 1, 4);
INSERT INTO tree_coefficient (tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max, preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max, spacing_meter, maintenance_level, aesthetic_score)
VALUES ('아까시나무', 'Robinia pseudoacacia', '낙엽활엽수', 0.173, 2.178, 0.8, 0.461, 0.613, 1.558, 6, 30, 1, 5, 1, 3, 1, 6, 3.0, 1, 2);
INSERT INTO tree_coefficient (tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max, preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max, spacing_meter, maintenance_level, aesthetic_score)
VALUES ('자작나무', 'Betula platyphylla', '낙엽활엽수', 0.076, 2.503, 0.6, 0.349, 0.558, 1.388, 6, 40, 1, 3, 1, 2, 2, 4, 4.0, 2, 5);
INSERT INTO tree_coefficient (tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max, preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max, spacing_meter, maintenance_level, aesthetic_score)
VALUES ('서어나무', 'Carpinus laxiflora', '낙엽활엽수', 0.255, 2.001, 0.5, 0.262, 0.614, 1.693, 6, 30, 2, 4, 1, 2, 3, 5, 4.0, 1, 3);
INSERT INTO tree_coefficient (tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max, preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max, spacing_meter, maintenance_level, aesthetic_score)
VALUES ('튤립나무', 'Liriodendron tulipifera', '낙엽활엽수', 0.121, 2.288, 0.9, 0.234, 0.458, 1.260, 6, 50, 1, 3, 1, 2, 3, 5, 5.0, 2, 5);
INSERT INTO tree_coefficient (tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max, preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max, spacing_meter, maintenance_level, aesthetic_score)
VALUES ('밤나무', 'Castanea crenata', '낙엽활엽수', 0.0003, 4.217, 0.6, 0.419, 0.510, 2.459, 6, 30, 1, 3, 1, 2, 3, 5, 5.0, 2, 3);
INSERT INTO tree_coefficient (tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max, preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max, spacing_meter, maintenance_level, aesthetic_score)
VALUES ('현사시나무', 'Populus tomentiglandulosa', '낙엽활엽수', 0.078, 2.409, 1.0, 0.164, 0.363, 1.174, 6, 40, 2, 5, 1, 2, 3, 6, 3.0, 1, 2);

-- 상록활엽수 4종
INSERT INTO tree_coefficient (tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max, preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max, spacing_meter, maintenance_level, aesthetic_score)
VALUES ('구실잣밤나무', 'Castanopsis sieboldii', '상록활엽수', 0.223, 2.092, 0.5, 0.625, 0.583, 1.393, 6, 30, 2, 4, 1, 2, 3, 5, 4.0, 2, 4);
INSERT INTO tree_coefficient (tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max, preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max, spacing_meter, maintenance_level, aesthetic_score)
VALUES ('붉가시나무', 'Quercus acuta', '상록활엽수', 0.533, 1.877, 0.5, 0.214, 0.833, 1.467, 6, 40, 1, 3, 1, 2, 3, 5, 4.0, 2, 4);
INSERT INTO tree_coefficient (tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max, preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max, spacing_meter, maintenance_level, aesthetic_score)
VALUES ('동백나무', 'Camellia japonica', '상록활엽수', 0.034, 2.475, 0.4, 0.356, 0.657, 2.621, 6, 25, 2, 4, 1, 2, 3, 5, 3.0, 2, 5);
INSERT INTO tree_coefficient (tree_type, scientific_name, category, factora, factorb, annual_growth, root_ratio, wood_density, bef, dbh_min, dbh_max, preferred_drainage_min, preferred_drainage_max, preferred_depth_min, preferred_depth_max, preferred_texture_min, preferred_texture_max, spacing_meter, maintenance_level, aesthetic_score)
VALUES ('종가시나무', 'Quercus glauca', '상록활엽수', 0.021, 2.763, 0.4, 0.229, 0.763, 2.123, 6, 30, 1, 3, 1, 2, 3, 5, 4.0, 2, 4);

-- 인증 테이블
INSERT INTO certification
(member_id, grade, total_score, tree_count, total_carbon_absorption, status, issued_date, expire_date)
VALUES
    (1, '새싹', 50, 123, 82725, '활성화', '2026-04-07', '2027-04-08'),
    (2, '나무', 60, 453, 75878, '활성화', '2026-04-07', '2027-04-08'),
    (3, '새싹', 70, 371, 577575, '활성화', '2026-04-07', '2027-04-08'),
    (4, '새싹', 70, 378, 727557, '활성화', '2026-04-07', '2027-04-08'),
    (5, '나무', 80, 500, 900000, '활성화', '2026-04-08', '2027-04-09'),
    (6, '숲', 90, 650, 1200000, '활성화', '2026-04-08', '2027-04-09'),
    (7, '새싹', 40, 100, 60000, '비활성화', '2026-04-09', '2027-04-10'),
    (8, '나무', 75, 420, 800000, '활성화', '2026-04-09', '2027-04-10'),
    (9, '숲', 95, 700, 1500000, '활성화', '2026-04-10', '2027-04-11'),
    (10, '새싹', 55, 200, 100000, '비활성화', '2026-04-10', '2027-04-11');
