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

-- ================================= 기업 샘플 (20개) =================================
INSERT INTO company (company_id, company_name, business_number, ceo_name, start_date, address, business_license,
                     is_approved, create_date, update_date)
VALUES (1, '삼성전자', '124-81-00998', '이재용', '19690113', '경기도 수원시 영통구 삼성로 129', null, 1, now(), now()),
       (2, '카카오', '120-81-47521', '정신아', '20060203', '제주특별자치도 제주시 첨단로 242', null, 1, now(), now()),
       (3, '네이버', '220-81-62517', '최수연', '19990602', '경기도 성남시 분당구 불정로 6', null, 1, now(), now()),
       (4, 'LG전자', '107-86-14075', '조주완', '19580101', '서울특별시 영등포구 여의대로 128', null, 1, now(), now()),
       (5, 'SK하이닉스', '129-81-09558', '곽노정', '19830201', '경기도 이천시 부발읍 이천대로 2091', null, 1, now(), now()),
       (6, '현대자동차', '107-81-18268', '장재훈', '19670329', '서울특별시 서초구 헌릉로 12', null, 0, now(), now()),     -- 미승인
       (7, '기아', '106-81-16643', '송호성', '19440609', '서울특별시 서초구 헌릉로 12', null, 1, now(), now()),
       (8, 'SK텔레콤', '220-81-00264', '유영상', '19840303', '서울특별시 중구 을지로 65', null, 1, now(), now()),
       (9, 'KT', '502-81-13601', '김영섭', '19810101', '경기도 성남시 분당구 불정로 90', null, 1, now(), now()),
       (10, 'LG유플러스', '032-86-07750', '황현식', '19960401', '서울특별시 용산구 한강대로 32', null, 0, now(), now()),  -- 미승인
       (11, '포스코', '107-81-18366', '장인화', '19680401', '서울특별시 강남구 테헤란로 440', null, 1, now(), now()),
       (12, 'KB국민은행', '408-81-39950', '이재근', '19631001', '서울특별시 영등포구 국제금융로 8', null, 1, now(), now()),
       (13, '신한은행', '100-81-02535', '정상혁', '19820701', '서울특별시 중구 세종대로 9', null, 1, now(), now()),
       (14, '하나은행', '138-81-00220', '이승열', '19710201', '서울특별시 중구 을지로 66', null, 1, now(), now()),
       (15, '우리은행', '202-81-00197', '조병규', '19991227', '서울특별시 중구 소공로 51', null, 1, now(), now()),
       (16, '롯데케미칼', '107-81-18672', '신동빈', '19760201', '서울특별시 영등포구 여의대로 128', null, 0, now(), now()), -- 미승인
       (17, 'CJ제일제당', '110-81-02149', '최은석', '19530101', '서울특별시 중구 동호로 330', null, 1, now(), now()),
       (18, '두산에너빌리티', '113-81-00202', '박지원', '19621001', '경상남도 창원시 성산구 두산볼보로 22', null, 1, now(), now()),
       (19, 'HD현대', '120-81-00260', '정기선', '20021001', '경기도 성남시 분당구 판교로 344', null, 1, now(), now()),
       (20, 'GS칼텍스', '130-81-05064', '허세홍', '19670101', '서울특별시 강남구 논현로 508', null, 1, now(), now());

-- ================================= 회원 샘플 (20 + 관리자 1) =================================
-- 비밀번호 원본:
-- 1: vsn!2024#  2: ocean7788*  3: farm9900!  4: logic1234@  5: logis_best
-- 6: f_mobility!  7: ads_master1  8: hp_9988#  9: urban_it_00  10: mega_pass!
-- 11: cld!9900#  12: neo_med_24  13: atlas_pwr!  14: v_it_2026*  15: k_logis_pass
-- 16: urban_mgt_1  17: eco_tech_!@  18: edu_p_7788  19: iot_lab_001  20: prime_f_365
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

-- ================================= 전문가 샘플 (20명) =================================
-- 상태 분포: 가용 10, 파견 5, 휴직 3, 퇴직 2
INSERT INTO expert (expert_name, expert_number, expert_email, expert_state, s_address, create_date, update_date)
VALUES ('김철수', '010-1111-0001', 'xm3003@naver.com', '가용', '서울특별시 강남구 테헤란로 10', NOW(), NOW()),
       ('이영희', '010-2222-0002', 'young2@green.com', '파견', '부산광역시 해운대구 우동 20', NOW(), NOW()),
       ('박지민', '010-3333-0003', 'jimin3@green.com', '가용', '대구광역시 중구 중앙대로 30', NOW(), NOW()),
       ('최수호', '010-4444-0004', 'suho4@green.com', '휴직', '인천광역시 미추홀구 주안동 40', NOW(), NOW()),
       ('정다은', '010-5555-0005', 'daeun5@green.com', '가용', '광주광역시 북구 설죽로 50', NOW(), NOW()),
       ('강민호', '010-6666-0006', 'min6@green.com', '퇴직', '대전광역시 서구 둔산로 60', NOW(), NOW()),
       ('윤서연', '010-7777-0007', 'seo7@green.com', '파견', '울산광역시 남구 삼산로 70', NOW(), NOW()),
       ('임도현', '010-8888-0008', 'do8@green.com', '가용', '세종특별자치시 도움8로 80', NOW(), NOW()),
       ('한지아', '010-9999-0009', 'jia9@green.com', '가용', '경기도 안양시 동안구 시민대로 90', NOW(), NOW()),
       ('오지훈', '010-1234-0010', 'hun10@green.com', '파견', '강원특별자치도 춘천시 중앙로 100', NOW(), NOW()),
       ('송미경', '010-2345-0011', 'song11@green.com', '가용', '충청북도 청주시 상당구 110', NOW(), NOW()),
       ('권태윤', '010-3456-0012', 'kwon12@green.com', '휴직', '충청남도 천안시 서북구 120', NOW(), NOW()),
       ('신재이', '010-4567-0013', 'shin13@green.com', '가용', '전북특별자치도 전주시 완산구 130', NOW(), NOW()),
       ('황준서', '010-5678-0014', 'hwang14@green.com', '퇴직', '전라남도 목포시 통일대로 140', NOW(), NOW()),
       ('백지혜', '010-6789-0015', 'baek15@green.com', '파견', '경상북도 포항시 남구 150', NOW(), NOW()),
       ('유하은', '010-7890-0016', 'yu16@green.com', '가용', '경상남도 창원시 성산구 160', NOW(), NOW()),
       ('조성민', '010-8901-0017', 'cho17@green.com', '가용', '제주특별자치도 제주시 노형로 170', NOW(), NOW()),
       ('문지혜', '010-9012-0018', 'moon18@green.com', '파견', '경기도 수원시 영통구 180', NOW(), NOW()),
       ('양준혁', '010-0123-0019', 'yang19@green.com', '가용', '서울특별시 송파구 올림픽로 190', NOW(), NOW()),
       ('서예지', '010-1357-0020', 'seo20@green.com', '휴직', '부산광역시 수영구 광안동 200', NOW(), NOW());

-- ================================= 답사신청 샘플 (20건) =================================
-- 기업별 골고루 분포: 12개 기업 커버
-- 상태 분포: 완료 12, 진행중 4, 신청 4
-- member→company: 1→LG전자, 2→삼성전자, 4→SK텔레콤, 5→SK텔레콤, 6→SK하이닉스
--                 8→두산, 9→네이버, 10→HD현대, 12→카카오, 14→네이버
--                 15→기아, 17→CJ제일제당, 18→GS칼텍스, 19→삼성전자, 20→두산
INSERT INTO application (member_id, expert_id, times, survey_status, content,
                         due_start_date, due_end_date, create_date, update_date)
VALUES
    -- 완료 12건 (detail_id 1~12) → expert_report 데이터 있음
    (1,  1,  0, '완료', 'LG전자 강남 사옥 소규모 조경 답사',       '2026-01-10', '2026-01-14', NOW(), NOW()),   -- 씨앗급: 소형 나무 3그루
    (2,  3,  1, '완료', '삼성전자 수원 공장 소나무 대규모 답사',     '2026-01-20', '2026-01-24', NOW(), NOW()),   -- 산림급: 대형 소나무 7그루
    (6,  5,  0, '완료', 'SK하이닉스 이천 캠퍼스 편백 답사',         '2026-02-01', '2026-02-05', NOW(), NOW()),   -- 숲급: 중대형 편백 6그루
    (5,  8,  2, '완료', 'SK텔레콤 부산 물류센터 혼합 답사',         '2026-02-10', '2026-02-14', NOW(), NOW()),   -- 새싹급: 중형 혼합 4그루
    (8,  9,  0, '완료', '두산 대구 공장 메타세쿼이아 답사',         '2026-02-20', '2026-02-24', NOW(), NOW()),   -- 산림급: 초대형 메타세쿼이아 6그루
    (9, 11,  1, '완료', '네이버 성수 사옥 느티나무 가로수 답사',     '2026-03-01', '2026-03-05', NOW(), NOW()),   -- 숲급: 대형 느티나무 5그루
    (10, 13, 0, '완료', 'HD현대 인천 물류센터 소규모 조경 답사',     '2026-03-10', '2026-03-14', NOW(), NOW()),   -- 씨앗급: 묘목 4그루
    (12, 16, 1, '완료', '카카오 제주 본사 벚나무 답사',             '2026-03-15', '2026-03-19', NOW(), NOW()),   -- 새싹급: 중형 벚나무 5그루
    (15, 19, 0, '완료', '기아 공항 물류센터 참나무 답사',           '2026-03-25', '2026-03-29', NOW(), NOW()),   -- 숲급: 대형 참나무 5그루
    (17,  1, 2, '완료', 'CJ제일제당 나주 공장 대규모 조림 답사',    '2026-04-01', '2026-04-05', NOW(), NOW()),   -- 산림급: 다수 대형 7그루
    (18,  3, 0, '완료', 'GS칼텍스 역삼 사옥 은행나무 답사',         '2026-04-05', '2026-04-09', NOW(), NOW()),   -- 새싹급: 중형 은행나무 4그루
    (19,  5, 1, '완료', '삼성전자 성남 연구소 자작나무 답사',        '2026-04-08', '2026-04-12', NOW(), NOW()),   -- 씨앗급: 소형 자작나무 3그루
    -- 진행중 4건 (detail_id 13~16)
    (1, 15, 3, '진행중', 'LG전자 평택 공장 2차 조경 답사',          '2026-04-10', '2026-04-14', NOW(), NOW()),
    (14, 11, 2, '진행중', '네이버 가산 사옥 향나무 조경 답사',       '2026-04-11', '2026-04-15', NOW(), NOW()),
    (13,  7, 3, '진행중', '삼성전자 울산 공장 탄소흡수 답사',        '2026-04-12', '2026-04-16', NOW(), NOW()),
    (20, 19, 2, '진행중', '두산 음성 공장 단풍나무 답사',            '2026-04-13', '2026-04-17', NOW(), NOW()),
    -- 신청 4건 (detail_id 17~20)
    (4,  9, 0, '신청', 'SK텔레콤 을지로 본사 옥상 녹화 견적',       '2026-04-20', '2026-04-24', NOW(), NOW()),
    (16, 17, 0, '신청', 'SK텔레콤 종로 사옥 향나무 견적',           '2026-04-21', '2026-04-25', NOW(), NOW()),
    (5,  1, 0, '신청', 'SK텔레콤 해운대 지사 단풍나무 견적',        '2026-04-14', '2026-04-26', NOW(), NOW()),
    (12, 13, 0, '신청', '카카오 판교 신사옥 조경 견적',             '2026-04-23', '2026-04-27', NOW(), NOW());

-- ================================= 답사정보(나무) 샘플 =================================
-- 완료된 답사(detail_id 1~12)에 나무 데이터
-- 침엽수/활엽수 kind 정확 매칭
-- 침엽수: 소나무, 메타세쿼이아, 편백, 향나무
-- 활엽수: 은행나무, 단풍나무, 느티나무, 벚나무, 참나무, 자작나무
-- DBH 다양: 소형(8~15), 중형(16~30), 대형(31~45), 초대형(46~60)
INSERT INTO expert_report
(detail_id, tree_type, dbh, tree_status, picture, height, width, latitude, longitude, kind, create_date, update_date)
VALUES
    -- ■ detail_id=1: LG전자 강남 (씨앗급) - 소형 나무 3그루
    (1, '향나무',     10, '양호', 'https://picsum.photos/seed/t01/400/300',  5, 3, 37.5035, 127.0446, '침엽수', now(), now()),
    (1, '단풍나무',    8, '보통', 'https://picsum.photos/seed/t02/400/300',  4, 3, 37.5036, 127.0445, '활엽수', now(), now()),
    (1, '벚나무',     12, '양호', 'https://picsum.photos/seed/t03/400/300',  6, 4, 37.5034, 127.0447, '활엽수', now(), now()),

    -- ■ detail_id=2: 삼성전자 수원 (산림급) - 대형 소나무 위주 7그루
    (2, '소나무',     48, '양호', 'https://picsum.photos/seed/t04/400/300', 20, 13, 37.2861, 127.0577, '침엽수', now(), now()),
    (2, '소나무',     52, '양호', 'https://picsum.photos/seed/t05/400/300', 22, 14, 37.2862, 127.0576, '침엽수', now(), now()),
    (2, '소나무',     45, '보통', 'https://picsum.photos/seed/t06/400/300', 18, 12, 37.2860, 127.0578, '침엽수', now(), now()),
    (2, '소나무',     50, '양호', 'https://picsum.photos/seed/t07/400/300', 21, 13, 37.2859, 127.0576, '침엽수', now(), now()),
    (2, '느티나무',   40, '양호', 'https://picsum.photos/seed/t08/400/300', 16, 12, 37.2861, 127.0579, '활엽수', now(), now()),
    (2, '단풍나무',   35, '보통', 'https://picsum.photos/seed/t09/400/300', 14, 10, 37.2858, 127.0577, '활엽수', now(), now()),
    (2, '은행나무',   38, '양호', 'https://picsum.photos/seed/t10/400/300', 15, 11, 37.2860, 127.0575, '활엽수', now(), now()),

    -- ■ detail_id=3: SK하이닉스 이천 (숲급) - 중대형 편백 위주 6그루
    (3, '편백',       35, '양호', 'https://picsum.photos/seed/t11/400/300', 15, 8,  37.2750, 127.4378, '침엽수', now(), now()),
    (3, '편백',       32, '양호', 'https://picsum.photos/seed/t12/400/300', 14, 7,  37.2751, 127.4377, '침엽수', now(), now()),
    (3, '편백',       30, '보통', 'https://picsum.photos/seed/t13/400/300', 13, 7,  37.2749, 127.4379, '침엽수', now(), now()),
    (3, '편백',       28, '양호', 'https://picsum.photos/seed/t14/400/300', 12, 6,  37.2748, 127.4378, '침엽수', now(), now()),
    (3, '자작나무',   22, '양호', 'https://picsum.photos/seed/t15/400/300',  9, 5,  37.2750, 127.4380, '활엽수', now(), now()),
    (3, '벚나무',     18, '보통', 'https://picsum.photos/seed/t16/400/300',  8, 5,  37.2752, 127.4376, '활엽수', now(), now()),

    -- ■ detail_id=4: SK텔레콤 부산 (새싹급) - 소중형 혼합 4그루
    (4, '참나무',     14, '양호', 'https://picsum.photos/seed/t17/400/300',  7, 5,  35.0953, 128.8328, '활엽수', now(), now()),
    (4, '소나무',     12, '보통', 'https://picsum.photos/seed/t18/400/300',  6, 4,  35.0954, 128.8327, '침엽수', now(), now()),
    (4, '느티나무',   15, '양호', 'https://picsum.photos/seed/t19/400/300',  7, 5,  35.0952, 128.8329, '활엽수', now(), now()),
    (4, '은행나무',   13, '불량', 'https://picsum.photos/seed/t20/400/300',  6, 4,  35.0951, 128.8328, '활엽수', now(), now()),

    -- ■ detail_id=5: 두산 대구 (산림급) - 초대형 메타세쿼이아 위주 6그루
    (5, '메타세쿼이아', 58, '양호', 'https://picsum.photos/seed/t21/400/300', 28, 9,  35.8698, 128.5937, '침엽수', now(), now()),
    (5, '메타세쿼이아', 55, '양호', 'https://picsum.photos/seed/t22/400/300', 26, 8,  35.8699, 128.5936, '침엽수', now(), now()),
    (5, '메타세쿼이아', 52, '보통', 'https://picsum.photos/seed/t23/400/300', 25, 8,  35.8697, 128.5938, '침엽수', now(), now()),
    (5, '참나무',       45, '양호', 'https://picsum.photos/seed/t24/400/300', 18, 13, 35.8696, 128.5937, '활엽수', now(), now()),
    (5, '느티나무',     42, '양호', 'https://picsum.photos/seed/t25/400/300', 17, 12, 35.8698, 128.5939, '활엽수', now(), now()),
    (5, '소나무',       40, '보통', 'https://picsum.photos/seed/t26/400/300', 16, 10, 35.8700, 128.5936, '침엽수', now(), now()),

    -- ■ detail_id=6: 네이버 성수 (숲급) - 중형 느티나무 가로수 5그루
    (6, '느티나무',   25, '양호', 'https://picsum.photos/seed/t27/400/300', 11, 8,  37.5446, 127.0569, '활엽수', now(), now()),
    (6, '느티나무',   22, '양호', 'https://picsum.photos/seed/t28/400/300', 10, 7,  37.5447, 127.0568, '활엽수', now(), now()),
    (6, '느티나무',   24, '보통', 'https://picsum.photos/seed/t29/400/300', 10, 7,  37.5445, 127.0570, '활엽수', now(), now()),
    (6, '은행나무',   20, '양호', 'https://picsum.photos/seed/t30/400/300',  8, 6,  37.5444, 127.0569, '활엽수', now(), now()),
    (6, '소나무',     18, '양호', 'https://picsum.photos/seed/t31/400/300',  8, 5,  37.5446, 127.0571, '침엽수', now(), now()),

    -- ■ detail_id=7: HD현대 인천 (씨앗급) - 묘목급 소형 4그루
    (7, '자작나무',    9, '양호', 'https://picsum.photos/seed/t32/400/300',  4, 3,  37.4492, 126.4505, '활엽수', now(), now()),
    (7, '단풍나무',   11, '보통', 'https://picsum.photos/seed/t33/400/300',  5, 3,  37.4493, 126.4504, '활엽수', now(), now()),
    (7, '향나무',      8, '양호', 'https://picsum.photos/seed/t34/400/300',  4, 2,  37.4491, 126.4506, '침엽수', now(), now()),
    (7, '벚나무',     10, '양호', 'https://picsum.photos/seed/t35/400/300',  5, 3,  37.4490, 126.4505, '활엽수', now(), now()),

    -- ■ detail_id=8: 카카오 제주 (새싹급) - 소중형 벚나무 위주 4그루
    (8, '벚나무',     15, '양호', 'https://picsum.photos/seed/t36/400/300',  7, 5,  33.4507, 126.5706, '활엽수', now(), now()),
    (8, '벚나무',     13, '양호', 'https://picsum.photos/seed/t37/400/300',  6, 4,  33.4508, 126.5705, '활엽수', now(), now()),
    (8, '벚나무',     12, '보통', 'https://picsum.photos/seed/t38/400/300',  5, 4,  33.4506, 126.5707, '활엽수', now(), now()),
    (8, '향나무',     14, '양호', 'https://picsum.photos/seed/t39/400/300',  6, 4,  33.4505, 126.5706, '침엽수', now(), now()),

    -- ■ detail_id=9: 기아 인천공항 (숲급) - 중대형 참나무 위주 5그루
    (9, '참나무',     25, '양호', 'https://picsum.photos/seed/t41/400/300', 11, 8,  37.4600, 126.4400, '활엽수', now(), now()),
    (9, '참나무',     22, '양호', 'https://picsum.photos/seed/t42/400/300', 10, 7,  37.4601, 126.4399, '활엽수', now(), now()),
    (9, '참나무',     20, '보통', 'https://picsum.photos/seed/t43/400/300',  9, 6,  37.4599, 126.4401, '활엽수', now(), now()),
    (9, '편백',       18, '양호', 'https://picsum.photos/seed/t44/400/300',  8, 5,  37.4598, 126.4400, '침엽수', now(), now()),
    (9, '소나무',     20, '양호', 'https://picsum.photos/seed/t45/400/300',  9, 6,  37.4600, 126.4402, '침엽수', now(), now()),

    -- ■ detail_id=10: CJ제일제당 나주 (산림급) - 대규모 혼합 7그루
    (10, '소나무',     50, '양호', 'https://picsum.photos/seed/t46/400/300', 20, 12, 35.0168, 126.7905, '침엽수', now(), now()),
    (10, '소나무',     48, '양호', 'https://picsum.photos/seed/t47/400/300', 19, 11, 35.0169, 126.7904, '침엽수', now(), now()),
    (10, '편백',       45, '양호', 'https://picsum.photos/seed/t48/400/300', 18, 10, 35.0167, 126.7906, '침엽수', now(), now()),
    (10, '참나무',     42, '보통', 'https://picsum.photos/seed/t49/400/300', 17, 12, 35.0166, 126.7905, '활엽수', now(), now()),
    (10, '느티나무',   40, '양호', 'https://picsum.photos/seed/t50/400/300', 16, 11, 35.0168, 126.7907, '활엽수', now(), now()),
    (10, '메타세쿼이아', 55, '양호', 'https://picsum.photos/seed/t51/400/300', 26, 8, 35.0170, 126.7904, '침엽수', now(), now()),
    (10, '은행나무',   35, '보통', 'https://picsum.photos/seed/t52/400/300', 14, 9,  35.0166, 126.7906, '활엽수', now(), now()),

    -- ■ detail_id=11: GS칼텍스 역삼 (새싹급) - 소중형 은행나무 위주 4그루
    (11, '은행나무',   16, '양호', 'https://picsum.photos/seed/t53/400/300',  7, 5,  37.5004, 127.0364, '활엽수', now(), now()),
    (11, '은행나무',   14, '보통', 'https://picsum.photos/seed/t54/400/300',  6, 4,  37.5005, 127.0363, '활엽수', now(), now()),
    (11, '단풍나무',   13, '양호', 'https://picsum.photos/seed/t55/400/300',  6, 4,  37.5003, 127.0365, '활엽수', now(), now()),
    (11, '향나무',     12, '양호', 'https://picsum.photos/seed/t56/400/300',  5, 3,  37.5002, 127.0364, '침엽수', now(), now()),

    -- ■ detail_id=12: 삼성전자 성남 (씨앗급) - 소형 자작나무 3그루
    (12, '자작나무',   12, '양호', 'https://picsum.photos/seed/t57/400/300',  6, 4,  37.4020, 127.1045, '활엽수', now(), now()),
    (12, '자작나무',   10, '보통', 'https://picsum.photos/seed/t58/400/300',  5, 3,  37.4021, 127.1044, '활엽수', now(), now()),
    (12, '소나무',     14, '양호', 'https://picsum.photos/seed/t59/400/300',  7, 4,  37.4019, 127.1046, '침엽수', now(), now());

-- ================================= 상대생장식 계수 (carbon_coefficient) =================================
INSERT INTO carbon_coefficient (tree_type, factora, factorb, annual_growth, root_ratio, wood_density, bef)
VALUES ('침엽수', 0.129, 2.336, 0.55, 0.272, 0.439, 1.444);
INSERT INTO carbon_coefficient (tree_type, factora, factorb, annual_growth, root_ratio, wood_density, bef)
VALUES ('활엽수', 0.180, 2.406, 0.61, 0.341, 0.623, 1.650);

-- ================================= 나무 추천용 22종 (tree_coefficient) =================================
-- 출처: 국립산림과학원(2014) 한국 주요 수종별 탄소배출계수 및 바이오매스 상대생장식

-- 침엽수 8종
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

-- ================================= 인증마크 샘플 (16건) =================================
-- 멤버당 1개만 가능 (findByMember_Mid → 단일 반환)
-- 실제 등급은 expert_report live 계산으로 결정됨
-- 이 테이블은 발급일/만료일 스냅샷 용도
-- 4등급 × 4명 = 16건 골고루 분배
INSERT INTO certification
(member_id, grade, total_score, tree_count, total_carbon_absorption, status, issued_date, expire_date)
VALUES
    -- 씨앗 4건 (<500kg)
    (1,  '씨앗', 25, 3,   180, '활성화',   '2026-01-15', '2027-01-15'),  -- LG전자: 소형 3그루
    (10, '씨앗', 20, 4,   120, '활성화',   '2026-03-10', '2027-03-10'),  -- HD현대: 묘목 4그루
    (19, '씨앗', 22, 3,    95, '활성화',   '2026-04-08', '2027-04-08'),  -- 삼성전자(성남): 소형 자작나무
    (4,  '씨앗', 18, 2,   250, '비활성화', '2025-09-01', '2026-09-01'),  -- SK텔레콤: 만료

    -- 새싹 4건 (500~2000kg)
    (5,  '새싹', 45, 4,   850, '활성화',   '2026-02-10', '2027-02-10'),  -- SK텔레콤(부산): 중형 혼합
    (12, '새싹', 50, 5,  1200, '활성화',   '2026-03-15', '2027-03-15'),  -- 카카오(제주): 벚나무
    (18, '새싹', 42, 4,   680, '활성화',   '2026-04-05', '2027-04-05'),  -- GS칼텍스: 은행나무
    (14, '새싹', 48, 6,  1500, '비활성화', '2025-08-20', '2026-08-20'),  -- 네이버(가산): 만료

    -- 숲 4건 (2000~5000kg)
    (6,  '숲',   72, 6,  3200, '활성화',   '2026-02-01', '2027-02-01'),  -- SK하이닉스: 편백
    (9,  '숲',   78, 5,  4100, '활성화',   '2026-03-01', '2027-03-01'),  -- 네이버(성수): 느티나무
    (15, '숲',   75, 5,  3800, '활성화',   '2026-03-25', '2027-03-25'),  -- 기아: 참나무
    (13, '숲',   68, 8,  2500, '비활성화', '2025-10-15', '2026-10-15'),  -- 삼성전자(울산): 만료

    -- 산림 4건 (5000kg+)
    (2,  '산림', 92, 7,  8500, '활성화',   '2026-01-20', '2027-01-20'),  -- 삼성전자(수원): 대형 소나무
    (8,  '산림', 88, 6,  7200, '활성화',   '2026-02-20', '2027-02-20'),  -- 두산(대구): 메타세쿼이아
    (17, '산림', 95, 7, 12000, '활성화',   '2026-04-01', '2027-04-01'),  -- CJ제일제당: 대규모 혼합
    (16, '산림', 85, 10, 5800, '비활성화', '2025-07-01', '2026-07-01');  -- SK텔레콤(종로): 만료
