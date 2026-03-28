-- ================================= 지역코드 마스터 (17개 시도) =================================
INSERT INTO region_code (region_id, region_name, nx, ny) VALUES (1, '서울', 60, 127);
INSERT INTO region_code (region_id, region_name, nx, ny) VALUES (2, '부산', 98, 76);
INSERT INTO region_code (region_id, region_name, nx, ny) VALUES (3, '대구', 89, 90);
INSERT INTO region_code (region_id, region_name, nx, ny) VALUES (4, '인천', 55, 124);
INSERT INTO region_code (region_id, region_name, nx, ny) VALUES (5, '광주', 58, 74);
INSERT INTO region_code (region_id, region_name, nx, ny) VALUES (6, '대전', 67, 100);
INSERT INTO region_code (region_id, region_name, nx, ny) VALUES (7, '울산', 102, 84);
INSERT INTO region_code (region_id, region_name, nx, ny) VALUES (8, '세종', 66, 103);
INSERT INTO region_code (region_id, region_name, nx, ny) VALUES (9, '경기', 60, 120);
INSERT INTO region_code (region_id, region_name, nx, ny) VALUES (10, '강원', 73, 134);
INSERT INTO region_code (region_id, region_name, nx, ny) VALUES (11, '충북', 69, 107);
INSERT INTO region_code (region_id, region_name, nx, ny) VALUES (12, '충남', 68, 100);
INSERT INTO region_code (region_id, region_name, nx, ny) VALUES (13, '전북', 63, 89);
INSERT INTO region_code (region_id, region_name, nx, ny) VALUES (14, '전남', 51, 67);
INSERT INTO region_code (region_id, region_name, nx, ny) VALUES (15, '경북', 89, 91);
INSERT INTO region_code (region_id, region_name, nx, ny) VALUES (16, '경남', 91, 77);
INSERT INTO region_code (region_id, region_name, nx, ny) VALUES (17, '제주', 52, 38);

-- ================================= 기업테이블 샘플 코드 =================================
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (1, '삼성전자', '124-81-00998', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (2, '현대자동차', '101-81-15116', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (3, 'LG전자', '107-86-14075', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (4, 'SK하이닉스', '228-81-04380', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (5, '네이버', '220-81-62517', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (6, '카카오', '120-81-47521', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (7, '포스코홀딩스', '602-81-13475', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (8, 'KB금융지주', '201-86-08254', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (9, '신한금융지주', '102-81-34580', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (10, '하나금융지주', '107-86-05765', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (11, '우리금융지주', '201-86-52740', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (12, '기아자동차', '119-81-02316', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (13, '롯데쇼핑', '102-86-23423', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (14, '신세계', '201-81-27699', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (15, 'CJ제일제당', '104-81-02878', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (16, '아모레퍼시픽', '106-81-11810', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (17, 'LG화학', '104-81-02560', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (18, '한화솔루션', '116-81-02071', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (19, '두산에너빌리티', '314-81-05043', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (20, '현대중공업', '602-81-21820', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (21, '삼성물산', '116-81-05765', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (22, '현대건설', '104-81-36810', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (23, 'GS건설', '104-81-04147', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (24, '대우건설', '104-81-38890', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (25, 'HDC현대산업개발', '202-81-47718', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (26, '삼성SDI', '104-81-46990', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (27, 'LG에너지솔루션', '339-88-01370', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (28, 'SK이노베이션', '104-81-17709', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (29, 'GS칼텍스', '104-81-01700', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (30, 'S-OIL', '105-81-41696', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (31, '한국전력공사', '305-82-00040', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (32, 'KT', '102-81-42945', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (33, 'SKT텔레콤', '104-81-56967', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (34, 'LG유플러스', '104-86-51095', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (35, '대한항공', '110-81-14794', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (36, '아시아나항공', '106-81-45912', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (37, '제주항공', '106-86-34067', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (38, '진에어', '107-86-50652', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (39, 'CJ대한통운', '104-81-04991', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (40, '한진', '104-81-03018', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (41, '쿠팡', '120-88-00767', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (42, '배달의민족', '120-87-65763', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (43, '토스', '120-87-83139', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (44, '당근마켓', '783-87-00363', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (45, '야놀자', '119-86-53371', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (46, '직방', '220-87-35267', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (47, '무신사', '119-86-35385', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (48, '마켓컬리', '261-87-00107', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (49, '오늘의집', '144-87-00463', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (50, '리디', '113-86-82061', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (51, '넥슨코리아', '220-87-17483', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (52, '엔씨소프트', '140-81-35312', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (53, '넷마블', '107-87-30015', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (54, '크래프톤', '178-87-00676', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (55, '스마일게이트', '211-88-17220', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (56, '펄어비스', '130-86-67075', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (57, '카카오게임즈', '713-87-00560', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (58, '컴투스', '215-81-88109', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (59, '데브시스터즈', '114-86-97824', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (60, '웹젠', '107-86-51015', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (61, '하이브', '113-86-62430', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (62, 'SM엔터테인먼트', '114-81-52500', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (63, 'JYP엔터테인먼트', '107-86-29370', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (64, 'YG엔터테인먼트', '210-81-68960', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (65, 'CJ ENM', '104-81-12456', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (66, '스튜디오드래곤', '107-87-51231', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (67, 'NEW', '220-87-94218', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (68, 'CGV', '104-81-45690', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (69, '메가박스', '106-81-54678', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (70, '롯데시네마', '107-81-67432', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (71, '이마트', '206-81-50283', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (72, '홈플러스', '106-86-00620', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (73, '롯데마트', '101-85-34715', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (74, 'GS리테일', '116-81-18745', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (75, 'BGF리테일', '809-81-01574', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (76, '스타벅스코리아', '201-81-28830', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (77, '투썸플레이스', '211-87-35421', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (78, '이디야커피', '106-86-47512', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (79, '파리바게뜨', '116-81-15248', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (80, '뚜레쥬르', '104-81-47932', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (81, '현대백화점', '201-81-14889', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (82, '롯데백화점', '102-81-37264', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (83, '신세계백화점', '104-81-27699', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (84, '갤러리아', '201-81-15783', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (85, '한샘', '104-81-19294', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (86, '이케아코리아', '122-86-26296', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (87, '코웨이', '107-81-45729', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (88, '청호나이스', '116-81-25743', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (89, '교보문고', '201-81-36978', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (90, '영풍문고', '104-81-51823', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (91, '예스24', '106-81-65234', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (92, '알라딘', '201-81-48723', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (93, '셀트리온', '131-81-61347', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (94, '삼성바이오로직스', '137-86-40561', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (95, 'SK바이오팜', '201-86-29478', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (96, '유한양행', '104-81-00562', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (97, '녹십자', '116-81-05631', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (98, '한미약품', '107-81-37419', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (99, '대웅제약', '201-81-05621', now(), now());
INSERT INTO company (company_id, company_name, business_number, create_date, update_date)
VALUES (100, '종근당', '104-81-03471', now(), now());

-- ================================= 회원테이블 샘플 코드  =================================
INSERT INTO member (member_id, company_id, member_name, password, party_name, company_number, email, address,
                    create_date, update_date)
VALUES (1, 42, 'tech_vision_01', 'vsn!2024#', '김도윤', '010-2938-1029', 'dy.kim@techvision.co.kr', '서울특별시 강남구 테헤란로 427',
        now(), now()),
       (2, 15, 'blue_ocean_intl', 'ocean7788*', '이현우', '010-8821-3304', 'hwlee@blueocean.com', '경기도 성남시 분당구 판교역로 166',
        now(), now()),
       (3, 88, 'green_farm_korea', 'farm9900!', '박서준', '010-4456-7812', 'seo_jun@greenfarm.kr', '전라남도 나주시 빛가람로 350',
        now(), now()),
       (4, 2, 'smart_logic_lab', 'logic1234@', '최하은', '010-5567-1123', 'haeun.choi@smartlogic.io',
        '서울특별시 구로구 디지털로 300', now(), now()),
       (5, 67, 'global_logis_sys', 'logis_best', '정민호', '010-9901-2234', 'mh.jung@globallogis.net',
        '부산광역시 강서구 유통단지로 23', now(), now()),
       (6, 31, 'future_mob_dev', 'f_mobility!', '강지안', '010-3345-6678', 'jian.kang@futuremob.co.kr', '경기도 화성시 삼성로 1',
        now(), now()),
       (7, 94, 'creative_ads_kr', 'ads_master1', '윤소희', '010-7788-9901', 'sh.yoon@creativeads.com',
        '서울특별시 마포구 양화로 144', now(), now()),
       (8, 5, 'health_care_plus', 'hp_9988#', '한준영', '010-2211-4433', 'jy.han@healthcareplus.kr',
        '대구광역시 중구 달구벌대로 2077', now(), now()),
       (9, 56, 'urban_design_st', 'urban_it_00', '송미경', '010-6655-1100', 'mk.song@urbandesign.co.kr',
        '서울특별시 성동구 성수이로 113', now(), now()),
       (10, 19, 'mega_store_dist', 'mega_pass!', '임재상', '010-4499-8822', 'js.lim@megastore.co.kr', '인천광역시 부평구 부평대로 20',
        now(), now()),
       (11, 73, 'cloud_infra_sol', 'cld!9900#', '박준영', '010-3388-1122', 'jy.park@cloudinfra.co.kr',
        '서울특별시 서초구 서초대로 301', now(), now()),
       (12, 10, 'neo_medical_kr', 'neo_med_24', '이서연', '010-7744-8899', 'sy.lee@neomed.kr', '경기도 수원시 영통구 광교중앙로', now(),
        now()),
       (13, 82, 'atlas_heavy_ind', 'atlas_pwr!', '최동현', '010-2211-5544', 'dh.choi@atlasind.com', '울산광역시 동구 방어진순환도로',
        now(), now()),
       (14, 4, 'vision_it_group', 'v_it_2026*', '김민지', '010-4455-2233', 'mj.kim@visionit.io', '서울특별시 금천구 가산디지털1로',
        now(), now()),
       (15, 91, 'k_logistics_net', 'k_logis_pass', '정태우', '010-9988-7766', 'tw.jung@klogis.net', '인천광역시 중구 공항동로 295',
        now(), now()),
       (16, 25, 'urban_re_mgt', 'urban_mgt_1', '황수진', '010-1133-4422', 'sj.hwang@urbanmgt.co.kr', '서울특별시 종로구 율곡로 6',
        now(), now()),
       (17, 48, 'eco_power_tech', 'eco_tech_!@', '안재현', '010-5566-3311', 'jh.ahn@ecopower.kr', '전라남도 나주시 전력로 11', now(),
        now()),
       (18, 60, 'global_edu_plus', 'edu_p_7788', '윤하은', '010-8811-9922', 'he.yoon@eduplus.com', '서울특별시 강남구 역삼로 415',
        now(), now()),
       (19, 13, 'smart_iot_lab', 'iot_lab_001', '박성민', '010-2244-6688', 'sm.park@smartiot.io', '경기도 성남시 수정구 창업로 40',
        now(), now()),
       (20, 99, 'prime_food_sys', 'prime_f_365', '강도윤', '010-7799-1155', 'dy.kang@primefood.co.kr',
        '충청북도 음성군 원남면 원남산단로', now(), now()),
       (21, 37, 'blue_chip_semi', 'b_semi_202', '조현우', '010-3322-9988', 'hw.cho@bluechip.com', '경기도 평택시 고덕중앙로 10',
        now(), now()),
       (22, 54, 'daily_fresh_kr', 'fresh_day_1', '심보람', '010-5511-2244', 'br.sim@dailyfresh.kr', '서울특별시 송파구 가락몰로 1',
        now(), now()),
       (23, 7, 'auto_motive_x', 'am_x_pass!', '유승호', '010-1177-4499', 'sh.yu@automotivex.com', '경상남도 함안군 법수면 강주로',
        now(), now()),
       (24, 85, 'soft_bridge_it', 'sb_it_7788', '임나리', '010-8855-3322', 'nr.lim@softbridge.kr', '서울특별시 마포구 월드컵북로 5길',
        now(), now()),
       (25, 29, 'grand_const_kr', 'grand_c_!@', '신동주', '010-4422-7711', 'dj.shin@grandconst.co.kr',
        '서울특별시 용산구 한강대로 100', now(), now()),
       (26, 44, 'bio_cell_tech', 'biocell_123', '김은서', '010-2299-4466', 'es.kim@biocell.io', '인천광역시 연수구 송도과학로', now(),
        now()),
       (27, 6, 'mega_data_sol', 'm_data_889', '오지훈', '010-6633-1122', 'jh.oh@megadata.com', '서울특별시 성동구 광나루로 130', now(),
        now()),
       (28, 70, 'green_energy_p', 'green_p_001', '배현우', '010-9911-5533', 'hw.bae@greenenergy.kr', '대전광역시 대덕구 대화로 160',
        now(), now()),
       (29, 22, 'top_fashion_kr', 'top_fs_99#', '권다희', '010-3355-8844', 'dh.kwon@topfashion.co.kr',
        '서울특별시 중구 장충단로 253', now(), now()),
       (30, 81, 'pure_air_sys', 'p_air_2024', '한재현', '010-7722-4411', 'jh.han@pureair.com', '경기도 화성시 동탄첨단산업1로', now(),
        now()),
       (31, 14, 'ace_trading_intl', 'ace_tr_pass', '조민수', '010-1144-7788', 'ms.cho@acetrading.kr', '부산광역시 중구 해관로 12',
        now(), now()),
       (32, 63, 'smart_farm_co', 's_farm_!!1', '이지민', '010-5533-9911', 'jm.lee@smartfarm.co.kr', '경상북도 상주시 경상대로', now(),
        now()),
       (33, 90, 'future_ai_lab', 'f_ai_lab_x', '박건우', '010-8877-2244', 'gw.park@futureai.io', '서울특별시 강남구 논현로 508',
        now(), now()),
       (34, 45, 'global_biz_link', 'gbl_link_88', '서유진', '010-4499-1166', 'yj.seo@bizlink.com', '서울특별시 서초구 강남대로 369',
        now(), now()),
       (35, 12, 'well_being_food', 'well_b_202', '임재혁', '010-2255-7733', 'jh.lim@wellbeing.kr', '경기도 광주시 초월읍 산수로',
        now(), now()),
       (36, 57, 'star_comm_kr', 'star_com_77', '윤성호', '010-6611-3399', 'sh.yoon@starcomm.net', '서울특별시 영등포구 여의나루로',
        now(), now()),
       (37, 78, 'aqua_tech_sol', 'aqua_ts_9!', '손미나', '010-9944-1122', 'mn.son@aquatech.co.kr', '부산광역시 사하구 신평로 10',
        now(), now()),
       (38, 3, 'prime_estate_kr', 'p_estate_1', '안도윤', '010-3322-5577', 'dy.ahn@primeestate.com', '서울특별시 송파구 백제고분로',
        now(), now()),
       (39, 66, 'fine_chem_intl', 'fine_ch_00', '장우진', '010-7766-4422', 'wj.jang@finechem.kr', '울산광역시 남구 상개로 15', now(),
        now()),
       (40, 21, 'urban_style_kr', 'u_style_24', '최지유', '010-1188-3355', 'jy.choi@urbanstyle.co.kr',
        '서울특별시 강남구 신사동 541', now(), now()),
       (41, 89, 'hyper_logis_kr', 'hyper_l_99', '고태현', '010-5577-8822', 'th.ko@hyperlogis.com', '경기도 평택시 포승읍 평택항로',
        now(), now()),
       (42, 34, 'safety_first_kr', 'safety_f_0', '배은지', '010-8844-1133', 'ej.bae@safetyfirst.kr', '충청남도 천안시 서북구 2공단로',
        now(), now()),
       (43, 77, 'alpha_software', 'alpha_sw_!', '양지우', '010-4411-9955', 'jw.yang@alphasoft.io', '서울특별시 구로구 디지털로 26길',
        now(), now()),
       (44, 9, 'mega_media_st', 'm_media_77', '류성민', '010-2277-4411', 'sm.ryu@megamedia.co.kr', '서울특별시 마포구 상암산로 76',
        now(), now()),
       (45, 50, 'bright_edu_kr', 'bright_e_1', '조아라', '010-6644-2288', 'ar.cho@brightedu.com', '대구광역시 수성구 범어천로 126',
        now(), now()),
       (46, 17, 'ever_blue_tr', 'eb_tr_pass', '박지훈', '010-9922-7755', 'jh.park@everblue.kr', '서울특별시 중구 세종대로 39', now(),
        now()),
       (47, 84, 'ocean_pwr_sys', 'ocean_p_24', '송현호', '010-3355-1199', 'hh.song@oceanpwr.com', '부산광역시 영도구 해양로 301',
        now(), now()),
       (48, 62, 'dream_space_st', 'dream_sp_!', '심하은', '010-7711-8844', 'he.sim@dreamspace.io', '서울특별시 성동구 연무장길 7',
        now(), now()),
       (49, 1, 'total_parts_kr', 'total_p_88', '한승민', '010-1144-3322', 'sm.han@totalparts.co.kr', '인천광역시 서구 가남로 20',
        now(), now()),
       (50, 95, 'nature_bio_kr', 'nature_b_0', '김도현', '010-5599-4411', 'dh.kim@naturebio.kr', '강원도 춘천시 남산면 강촌로', now(),
        now()),
       (51, 33, 'k_food_global', 'yummy_kfood', '조예진', '010-1234-5678', 'yj.cho@kfood.com', '경기도 용인시 기흥구 기흥로 58', now(),
        now()),
       (52, 11, 'soft_wave_inc', 'swave_2024', '박지후', '010-9876-5432', 'jhpark@softwave.io', '서울특별시 송파구 중대로 135', now(),
        now()),
       (53, 65, 'bio_life_science', 'bio_lab_!!', '유은서', '010-1122-3344', 'es.yu@biolife.co.kr', '충청북도 청주시 오송읍 오송생명로',
        now(), now()),
       (54, 98, 'daily_beauty_kr', 'beauty_365', '권다인', '010-5544-3322', 'dain.kwon@dailybeauty.kr', '서울특별시 중구 명동길 26',
        now(), now()),
       (55, 18, 'prime_const_group', 'prime_77#', '신진우', '010-8877-6655', 'jw.shin@primeconst.com',
        '경기도 안양시 동안구 시민대로 180', now(), now()),
       (56, 40, 'ace_software_sol', 'ace_sol_01', '황민수', '010-4433-2211', 'ms.hwang@acesoft.kr', '대전광역시 유성구 대학로 291',
        now(), now()),
       (57, 72, 'ever_green_edu', 'edu_ever_10', '김나영', '010-2299-1188', 'ny.kim@evergreen.edu.kr',
        '서울특별시 노원구 동일로 214', now(), now()),
       (58, 8, 'power_energy_kr', 'p_energy_!', '오상훈', '010-3366-9922', 'sh.oh@powerenergy.com', '울산광역시 남구 번영로 123',
        now(), now()),
       (59, 53, 'ocean_view_resort', 'ocean_v_00', '백지아', '010-7744-1155', 'ja.baek@oceanview.co.kr',
        '강원도 강릉시 해안로 621', now(), now()),
       (60, 27, 'dream_inter_tr', 'dream_tr_88', '남궁건', '010-5522-4411', 'gun.nam@dreaminter.com',
        '서울특별시 영등포구 국제금융로 10', now(), now()),
       (61, 87, 'star_light_it', 'star_it_99', '류현지', '010-9911-3322', 'hj.ryu@starlight.io', '경기도 고양시 일산동구 중앙로 1030',
        now(), now()),
       (62, 16, 'grand_hotel_mgt', 'grand_h_12', '서태양', '010-2255-8877', 'ty.seo@grandhotel.co.kr',
        '서울특별시 용산구 소월로 322', now(), now()),
       (63, 49, 'alpha_trading_kr', 'alpha_tr_!!', '홍길동', '010-1188-4477', 'gd.hong@alphatrading.kr',
        '부산광역시 중구 중앙대로 80', now(), now()),
       (64, 76, 'modern_home_dec', 'modern_h_24', '장미래', '010-6633-9955', 'mr.jang@modernhome.com', '경기도 광주시 오포읍로 12',
        now(), now()),
       (65, 30, 'fast_delivery_sk', 'fast_sk_01', '고은호', '010-4411-7788', 'eh.ko@fastdelivery.co.kr',
        '서울특별시 양천구 목동동로 233', now(), now()),
       (66, 93, 'safe_security_kr', 'safe_sec_91', '배성준', '010-8822-1144', 'sj.bae@safesec.co.kr',
        '경기도 수원시 영통구 삼성로 129', now(), now()),
       (67, 36, 'total_office_sol', 'office_best', '안소윤', '010-3355-7799', 'sy.ahn@totaloffice.com',
        '서울특별시 성북구 화랑로 211', now(), now()),
       (68, 59, 'fine_dining_kr', 'fine_korea1', '양지훈', '010-7799-2244', 'jh.yang@finedining.kr', '서울특별시 강남구 도산대로 420',
        now(), now()),
       (69, 83, 'mega_chip_semi', 'semi_chip_0', '곽도현', '010-1144-8855', 'dh.kwak@megachip.com', '경기도 이천시 경충대로 2091',
        now(), now()),
       (70, 41, 'blue_sky_travel', 'sky_travel!', '문하늘', '010-5588-3366', 'hn.moon@blueskytravel.kr',
        '서울특별시 종로구 세종대로 149', now(), now()),
       (71, 100, 'world_fashion_it', 'fashion_it1', '박지민', '010-2288-4499', 'jm.park@worldfashion.com',
        '서울특별시 동대문구 장한로 22', now(), now()),
       (72, 51, 'nature_fresh_kr', 'nature_f_00', '최준우', '010-6622-9911', 'jw.choi@naturefresh.co.kr',
        '충청남도 천안시 서북구 번영로 156', now(), now()),
       (73, 23, 'smart_factory_kr', 's_factory_!', '이도윤', '010-3377-5511', 'dy.lee@smartfactory.kr',
        '경상남도 창원시 성산구 중앙대로 101', now(), now()),
       (74, 86, 'first_finance_in', 'first_fin_7', '정하준', '010-8811-4466', 'hj.jung@firstfinance.co.kr',
        '서울특별시 영등포구 의사당대로 1', now(), now()),
       (75, 47, 'cool_media_group', 'cool_m_2024', '송시아', '010-4466-2288', 'sa.song@coolmedia.net',
        '서울특별시 마포구 월드컵북로 396', now(), now()),
       (76, 55, 'bright_solar_kr', 'solar_power1', '윤민철', '010-1133-7744', 'mc.yoon@brightsolar.com',
        '전라북도 전주시 덕진구 기린대로 458', now(), now()),
       (77, 20, 'urban_bakery_kr', 'bread_love_1', '김다은', '010-5599-1133', 'de.kim@urbanbakery.kr',
        '서울특별시 성동구 아차산로 17', now(), now()),
       (78, 69, 'peak_outdoor_co', 'peak_gear_!!', '한승우', '010-9944-6622', 'sw.han@peakoutdoor.com',
        '경기도 의정부시 평화로 525', now(), now()),
       (79, 39, 'global_edu_link', 'edu_link_00', '강서윤', '010-2277-5599', 'sy.kang@globaledu.kr', '서울특별시 서초구 강남대로 311',
        now(), now()),
       (80, 97, 'happy_dental_cl', 'happy_d_202', '조현아', '010-7711-3355', 'ha.cho@happydental.com',
        '서울특별시 강서구 공항대로 206', now(), now()),
       (81, 61, 'aqua_marine_mgt', 'aqua_m_9988', '손지석', '010-3300-4488', 'js.son@aquamarine.kr', '부산광역시 해운대구 센텀서로 30',
        now(), now()),
       (82, 38, 'top_real_estate', 'top_re_1234', '권태현', '010-5577-1199', 'th.kwon@toprealestate.com',
        '서울특별시 강남구 역삼로 151', now(), now()),
       (83, 75, 'eco_friendly_kr', 'eco_world_1', '심지은', '010-1155-9933', 'je.sim@ecofriendly.co.kr',
        '경기도 용인시 수지구 포은대로 435', now(), now()),
       (84, 11, 'best_tour_korea', 'best_t_0077', '서우진', '010-8833-2211', 'wj.seo@besttour.kr', '서울특별시 중구 남대문로 109',
        now(), now()),
       (85, 43, 'golden_bridge_tr', 'g_bridge_!!', '임채원', '010-4400-6633', 'cw.lim@goldenbridge.com',
        '인천광역시 중구 서해대로 366', now(), now()),
       (86, 92, 'silver_care_sys', 'silver_c_22', '박정훈', '010-2266-4400', 'jh.park@silvercare.co.kr',
        '경기도 성남시 수정구 수정로 171', now(), now()),
       (87, 24, 'auto_parts_intl', 'auto_p_7788', '김성우', '010-7722-1166', 'sw.kim@autoparts.com', '경상북도 경주시 외동읍 산업로',
        now(), now()),
       (88, 58, 'pure_water_tech', 'water_p_123', '이지아', '010-3399-5522', 'ja.lee@purewater.kr', '대구광역시 달성군 국가산단대로',
        now(), now()),
       (89, 79, 'star_movie_dist', 'movie_s_202', '최승현', '010-9955-3311', 'sh.choi@starmovie.net', '서울특별시 용산구 한강대로 23',
        now(), now()),
       (90, 4, 'one_stop_logis', 'onestop_log', '유진혁', '010-1122-8844', 'jh.yu@onestoplogis.com', '경기도 김포시 고촌읍 아라육로',
        now(), now()),
       (91, 64, 'prime_logis_co', 'p_logis_77', '이지후', '010-8822-6644', 'jh.lee@primelogis.com', '경기도 광주시 오포로 101',
        now(), now()),
       (92, 100, 'soft_wave_intl', 'sw_intl_20', '정다인', '010-4477-1133', 'di.jung@softwave.kr', '서울특별시 서초구 반포대로 22',
        now(), now()),
       (93, 28, 'mega_store_sys', 'm_store_!@', '박재상', '010-2266-9955', 'js.park@megastore.net', '경기도 남양주시 순화궁로 249',
        now(), now()),
       (94, 71, 'global_const_g', 'gc_group_0', '황보민', '010-6688-2277', 'bm.hwang@globalconst.com', '서울특별시 종로구 종로 1',
        now(), now()),
       (95, 35, 'eco_fresh_kr', 'eco_f_365#', '서준영', '010-9944-3311', 'jy.seo@ecofresh.co.kr', '경상남도 진주시 에나로 128',
        now(), now()),
       (96, 80, 'smart_security', 's_sec_2026', '최하윤', '010-3311-7722', 'hy.choi@smartsec.io', '서울특별시 강서구 마곡중앙로', now(),
        now()),
       (97, 46, 'ace_finance_kr', 'ace_fin_11', '윤승후', '010-7755-1144', 'sh.yoon@acefinance.kr', '서울특별시 영등포구 국제금융로',
        now(), now()),
       (98, 96, 'urban_green_st', 'u_green_st', '임은채', '010-1122-8877', 'ec.lim@urbangreen.com', '경기도 안양시 동안구 부림로',
        now(), now()),
       (99, 52, 'bio_health_kr', 'bio_h_99#', '조건우', '010-5588-2266', 'gw.cho@biohealth.kr', '충청북도 청주시 흥덕구 오송읍', now(),
        now()),
       (100, 14, 'first_trading_c', 'first_tr_!*', '박지아', '010-8833-5599', 'ja.park@firsttrading.co.kr',
        '서울특별시 중구 남대문로 84', now(), now());
-- ================================= 전문가테이블 샘플 코드  =================================
INSERT INTO expert (expert_id, expert_name, expert_number, expert_email, expert_state, create_date, update_date)
VALUES (1, '김민준', '010-1234-5678', 'minjun.kim@arbo.co.kr', '활동중', now(),now()),
       (2, '이서연', '010-2345-6789', 'seoyeon.lee@greentech.kr', '활동중', now(), now()),
       (3, '박지훈', '010-3456-7890', 'jihoon.park@forest.go.kr', '활동중', now(), now()),
       (4, '최수아', '010-4567-8901', 'sua.choi@treeclinic.kr', '휴직', now(), now()),
       (5, '정우진', '010-5678-9012', 'woojin.jung@eco.co.kr', '활동중', now(), now()),
       (6, '강하은', '010-6789-0123', 'haeun.kang@arborist.kr', '활동중', now(), now()),
       (7, '조현우', '010-7890-1234', 'hyunwoo.jo@greenforest.kr', '퇴직', now(), now()),
       (8, '윤지아', '010-8901-2345', 'jia.yoon@treeman.co.kr',  '활동중', now(), now()),
       (9, '임도현', '010-9012-3456', 'dohyun.lim@eco.go.kr',  '활동중', now(), now()),
       (10, '한소희', '010-0123-4567', 'sohee.han@forest.co.kr',  '휴직', now(), now()),
       (11, '오승준', '010-1111-2222', 'seungjun.oh@arbo.kr',  '활동중', now(), now()),
       (12, '신예린', '010-2222-3333', 'yerin.shin@greenlab.kr', '활동중', now(), now()),
       (13, '권태양', '010-3333-4444', 'taeyang.kwon@treecare.kr', '활동중', now(), now()),
       (14, '남지원', '010-4444-5555', 'jiwon.nam@eco.co.kr',  '퇴직', now(), now()),
       (15, '황민서', '010-5555-6666', 'minseo.hwang@forest.go.kr',  '활동중', now(), now()),
       (16, '유준혁', '010-6666-7777', 'junhyuk.yu@arborist.co.kr',  '활동중', now(), now()),
       (17, '배나연', '010-7777-8888', 'nayeon.bae@greentech.kr', '휴직', now(), now()),
       (18, '서동현', '010-8888-9999', 'donghyun.seo@treeman.kr', '활동중', now(), now()),
       (19, '문채원', '010-9999-0000', 'chaewon.moon@eco.go.kr',  '활동중', now(), now()),
       (20, '류지성', '010-1357-2468', 'jisung.ryu@forest.co.kr', '활동중', now(), now()),
       (21, '노은서', '010-2468-1357', 'eunseo.no@arbo.co.kr', '퇴직', now(), now()),
       (22, '홍준서', '010-1122-3344', 'junseo.hong@greenlab.kr',  '활동중', now(), now()),
       (23, '전소율', '010-3344-5566', 'soyul.jeon@treecare.co.kr', '활동중', now(), now()),
       (24, '송민재', '010-5566-7788', 'minjae.song@eco.kr',  '휴직', now(), now()),
       (25, '안지후', '010-7788-9900', 'jihoo.ahn@forest.go.kr',  '활동중', now(), now()),
       (26, '김태리', '010-9900-1122', 'taeri.kim@arborist.kr',  '활동중', now(), now()),
       (27, '이현진', '010-1212-3434', 'hyunjin.lee@greentech.co.kr',  '활동중', now(), now()),
       (28, '박수현', '010-3434-5656', 'suhyun.park@treeman.kr',  '퇴직', now(), now()),
       (29, '최지민', '010-5656-7878', 'jimin.choi@eco.co.kr', '활동중', now(), now()),
       (30, '정하준', '010-7878-9090', 'hajun.jung@forest.kr', '활동중', now(), now()),
       (31, '강민호', '010-9090-1212', 'minho.kang@arbo.go.kr', '휴직', now(), now()),
       (32, '조서현', '010-1234-9876', 'seohyun.jo@greenlab.co.kr', '활동중', now(), now()),
       (33, '윤준영', '010-9876-5432', 'junyoung.yoon@treecare.kr', '활동중', now(), now()),
       (34, '임소연', '010-5432-1098', 'soyeon.lim@eco.go.kr', '활동중', now(), now()),
       (35, '한동욱', '010-1098-7654', 'dongwook.han@forest.co.kr',  '퇴직', now(), now()),
       (36, '오지은', '010-7654-3210', 'jieun.oh@arborist.co.kr',  '활동중', now(), now()),
       (37, '신우현', '010-3210-6789', 'woohyun.shin@greentech.kr',  '활동중', now(), now()),
       (38, '권나영', '010-6789-4321', 'nayoung.kwon@treeman.co.kr', '휴직', now(), now()),
       (39, '남도윤', '010-4321-8765', 'doyun.nam@eco.kr',  '활동중', now(), now()),
       (40, '황지훈', '010-8765-2109', 'jihoon.hwang@forest.go.kr',  '활동중', now(), now()),
       (41, '유서아', '010-2109-6543', 'seoa.yu@arbo.co.kr',  '활동중', now(), now()),
       (42, '배민준', '010-6543-0987', 'minjun.bae@greenlab.kr', '퇴직', now(), now()),
       (43, '서하린', '010-0987-4321', 'harin.seo@treecare.co.kr', '활동중', now(), now()),
       (44, '문준서', '010-4321-5678', 'junseo.moon@eco.co.kr', '활동중', now(), now()),
       (45, '류채은', '010-5678-8765', 'chaeeun.ryu@forest.kr',  '휴직', now(), now()),
       (46, '노태준', '010-8765-1234', 'taejun.no@arborist.go.kr',  '활동중', now(), now()),
       (47, '홍수민', '010-1234-0000', 'sumin.hong@greentech.co.kr',  '활동중', now(), now()),
       (48, '전지호', '010-0000-9999', 'jiho.jeon@treeman.kr', '활동중', now(), now()),
       (49, '송아영', '010-9999-1111', 'ayoung.song@eco.go.kr',  '퇴직', now(), now()),
       (50, '안현수', '010-1111-8888', 'hyunsu.ahn@forest.co.kr',  '활동중', now(), now()),
       (51, '김나현', '010-8888-2222', 'nahyun.kim@arbo.kr',  '활동중', now(), now()),
       (52, '이준호', '010-2222-7777', 'junho.lee@greenlab.co.kr',  '휴직', now(), now()),
       (53, '박다은', '010-7777-3333', 'daeun.park@treecare.kr',  '활동중', now(), now()),
       (54, '최승현', '010-3333-6666', 'seunghyun.choi@eco.kr',  '활동중', now(), now()),
       (55, '정유나', '010-6666-4444', 'yuna.jung@forest.go.kr',  '활동중', now(), now()),
       (56, '강지호', '010-4444-0555', 'jiho.kang@arborist.co.kr',  '퇴직', now(), now()),
       (57, '조민아', '010-5555-2222', 'mina.jo@greentech.kr',  '활동중', now(), now()),
       (58, '윤태현', '010-2222-4444', 'taehyun.yoon@treeman.co.kr',  '활동중', now(), now()),
       (59, '임하늘', '010-4444-1111', 'haneul.lim@eco.co.kr',  '휴직', now(), now()),
       (60, '한지수', '010-1111-3333', 'jisu.han@forest.kr',  '활동중', now(), now()),
       (61, '오민석', '010-3333-8888', 'minseok.oh@arbo.go.kr',  '활동중', now(), now()),
       (62, '신채연', '010-8888-6666', 'chaeyeon.shin@greenlab.kr', '활동중', now(), now()),
       (63, '권도현', '010-6666-2222', 'dohyun.kwon@treecare.co.kr', '퇴직', now(), now()),
       (64, '남수진', '010-2222-9999', 'sujin.nam@eco.go.kr', '활동중', now(), now()),
       (65, '황준혁', '010-9999-4444', 'junhyuk.hwang@forest.co.kr',  '활동중', now(), now()),
       (66, '유민경', '010-4444-7777', 'minkyung.yu@arborist.kr',  '휴직', now(), now()),
       (67, '배지훈', '010-7777-5555', 'jihoon.bae@greentech.co.kr',  '활동중', now(), now()),
       (68, '서수아', '010-5555-1111', 'sua.seo@treeman.kr',  '활동중', now(), now()),
       (69, '문태양', '010-1111-6666', 'taeyang.moon@eco.kr',  '활동중', now(), now()),
       (70, '류현우', '010-6666-3333', 'hyunwoo.ryu@forest.go.kr',  '퇴직', now(), now()),
       (71, '노지아', '010-3333-5555', 'jia.no@arbo.co.kr', '활동중', now(), now()),
       (72, '홍도현', '010-5555-9999', 'dohyun.hong@greenlab.co.kr',  '활동중', now(), now()),
       (73, '전하은', '010-9999-2222', 'haeun.jeon@treecare.kr',  '휴직', now(), now()),
       (74, '송승준', '010-2222-6666', 'seungjun.song@eco.co.kr',  '활동중', now(), now()),
       (75, '안예린', '010-6666-8888', 'yerin.ahn@forest.kr', '활동중', now(), now()),
       (76, '김지원', '010-8888-4444', 'jiwon.kim@arborist.co.kr', '활동중', now(), now()),
       (77, '이민서', '010-4444-2222', 'minseo.lee@greentech.kr', '퇴직', now(), now()),
       (78, '박준혁', '010-2222-5555', 'junhyuk.park@treeman.co.kr',  '활동중', now(), now()),
       (79, '최나연', '010-5555-7777', 'nayeon.choi@eco.go.kr', '활동중', now(), now()),
       (80, '정동현', '010-7777-1111', 'donghyun.jung@forest.co.kr', '휴직', now(), now()),
       (81, '강채원', '010-1111-9999', 'chaewon.kang@arbo.kr', '활동중', now(), now()),
       (82, '조지성', '010-9999-5555', 'jisung.jo@greenlab.kr',  '활동중', now(), now()),
       (83, '윤은서', '010-5555-3333', 'eunseo.yoon@treecare.co.kr', '활동중', now(), now()),
       (84, '임준서', '010-3333-7777', 'junseo.lim@eco.kr',  '퇴직', now(), now()),
       (85, '한소율', '010-7777-2222', 'soyul.han@forest.go.kr',  '활동중', now(), now()),
       (86, '오민재', '010-2222-8888', 'minjae.oh@arborist.kr',  '활동중', now(), now()),
       (87, '신지후', '010-8888-3333', 'jihoo.shin@greentech.co.kr',  '휴직', now(), now()),
       (88, '권태리', '010-3333-1111', 'taeri.kwon@treeman.kr',  '활동중', now(), now()),
       (89, '남현진', '010-1111-7777', 'hyunjin.nam@eco.co.kr',  '활동중', now(), now()),
       (90, '황수현', '010-7777-4444', 'suhyun.hwang@forest.kr', '활동중', now(), now()),
       (91, '유지민', '010-4444-6666', 'jimin.yu@arbo.go.kr',  '퇴직', now(), now()),
       (92, '배하준', '010-6666-1111', 'hajun.bae@greenlab.co.kr',  '활동중', now(), now()),
       (93, '서민호', '010-1111-5555', 'minho.seo@treecare.kr', '활동중', now(), now()),
       (94, '문서현', '010-5555-4444', 'seohyun.moon@eco.go.kr', '휴직', now(), now()),
       (95, '류준영', '010-4444-9999', 'junyoung.ryu@forest.co.kr',  '활동중', now(), now()),
       (96, '노소연', '010-9999-6666', 'soyeon.no@arborist.co.kr',  '활동중', now(), now()),
       (97, '홍동욱', '010-6666-5555', 'dongwook.hong@greentech.kr',  '활동중', now(), now()),
       (98, '전지은', '010-5555-8888', 'jieun.jeon@treeman.co.kr',  '퇴직', now(), now()),
       (99, '송민호', '010-8888-7777', 'minho.song@eco.go.kr',  '활동중', now(), now()),
       (100, '안채린', '010-7777-6666', 'chaerin.ahn@forest.co.kr',  '활동중', now(), now());
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

-- ================================= 탄소흡수량 계산 테이블 (tree_coefficient) =================================
-- 상대생장식: W = factorA × (DBH² × H)^factorB
-- 수령추정: age = DBH / annualGrowth
-- 탄소: CO₂(kg) = W × (1+rootRatio) × woodDensity × (44/12)

INSERT INTO tree_coefficient (tree_type, factora, factorb, annual_growth, root_ratio, wood_density)
VALUES ('침엽수', 0.0750, 0.9300, 0.6, 0.25, 0.45);
INSERT INTO tree_coefficient (tree_type, factora, factorb, annual_growth, root_ratio, wood_density)
VALUES ('활엽수', 0.1300, 0.8800, 0.8, 0.25, 0.68);