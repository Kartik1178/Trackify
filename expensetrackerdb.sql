--
-- PostgreSQL database dump
--

-- Dumped from database version 17.2
-- Dumped by pg_dump version 17.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.category (
    id integer NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE public.category OWNER TO postgres;

--
-- Name: categories_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categories_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.categories_id_seq OWNER TO postgres;

--
-- Name: categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categories_id_seq OWNED BY public.category.id;


--
-- Name: category_type; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.category_type (
    id integer NOT NULL,
    category_id integer,
    name character varying(100) NOT NULL
);


ALTER TABLE public.category_type OWNER TO postgres;

--
-- Name: category_type_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.category_type_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.category_type_id_seq OWNER TO postgres;

--
-- Name: category_type_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.category_type_id_seq OWNED BY public.category_type.id;


--
-- Name: expense; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.expense (
    id integer NOT NULL,
    type_id integer,
    sent_to character varying(100) NOT NULL,
    description text,
    amount numeric(10,2) NOT NULL,
    expense_date date NOT NULL,
    isactive boolean DEFAULT true NOT NULL,
    bill_no character varying(50)
);


ALTER TABLE public.expense OWNER TO postgres;

--
-- Name: expenses_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.expenses_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.expenses_id_seq OWNER TO postgres;

--
-- Name: expenses_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.expenses_id_seq OWNED BY public.expense.id;


--
-- Name: category id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category ALTER COLUMN id SET DEFAULT nextval('public.categories_id_seq'::regclass);


--
-- Name: category_type id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category_type ALTER COLUMN id SET DEFAULT nextval('public.category_type_id_seq'::regclass);


--
-- Name: expense id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expense ALTER COLUMN id SET DEFAULT nextval('public.expenses_id_seq'::regclass);


--
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.category (id, name) FROM stdin;
1	Groceries
2	Transportation
3	Fun
4	Healthcare
5	Utilities
6	Misc
8	Food
\.


--
-- Data for Name: category_type; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.category_type (id, category_id, name) FROM stdin;
1	1	Fruits and Vegetables
2	1	Dairy Products
3	2	Public Transport
4	2	Fuel
5	3	Dining Out
6	3	Snacks
9	5	Doctor Visits
10	5	Medicines
11	2	Test
12	1	Meat
8	3	Gaming
7	3	Movies
13	4	Medicines
14	4	Moisturizer
15	4	Soaps
\.


--
-- Data for Name: expense; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.expense (id, type_id, sent_to, description, amount, expense_date, isactive, bill_no) FROM stdin;
4	1	TestUser	this is to pay electricity bill	3.00	2024-03-04	f	\N
5	1	TestUser	this is to pay electricity bill	3.00	2024-03-04	f	\N
6	1	TestUser	this is for buying milk	40.00	2024-03-04	f	\N
9	\N	test	\N	2.00	2004-02-12	t	\N
10	\N	test	\N	2.00	2004-02-12	t	\N
11	\N	test	\N	2.00	2004-02-12	t	\N
12	\N	test	\N	2.00	2004-02-12	t	\N
13	\N	test	\N	2.00	2004-02-12	t	\N
14	\N	supermarket	\N	444.00	2025-01-08	t	\N
15	\N	supermarket	\N	444.00	2025-01-08	t	\N
16	\N	METRO	\N	45.00	2025-01-22	t	\N
17	\N	METRO	\N	45.00	2025-01-08	t	\N
18	\N	METRO	\N	45.00	2025-01-08	t	\N
19	\N	METRO	\N	45.00	2025-01-13	t	\N
20	\N	METRO	\N	45.00	2025-01-13	t	\N
21	\N	METRO	\N	45.00	2025-01-09	t	\N
22	\N	METRO	\N	45.00	2025-01-09	t	\N
23	\N	METRO	\N	45.00	2025-01-09	t	\N
24	\N	METRO	\N	45.00	2025-01-15	t	\N
25	\N	METRO	\N	45.00	2025-01-08	t	\N
26	\N	METRO	\N	34.00	2025-01-07	t	\N
27	\N	METRO	\N	34.00	2025-01-07	t	\N
28	\N	METRO	\N	34.00	2025-01-07	t	\N
29	\N	METRO	\N	45.00	2025-01-03	t	\N
30	\N	METRO	\N	45.00	2025-01-02	t	\N
31	\N	METRO	\N	34.00	2025-01-15	t	\N
32	\N	METRO	\N	45.00	2025-01-15	t	\N
34	\N	TestUser	this is for buying 	40.00	2024-03-04	t	\N
36	3	TestUser	this is for buying	40.00	2024-03-04	t	\N
43	3	TestUser	this is for buying	40.00	2024-03-04	t	\N
44	3	TestUser	this is for buying	40.00	2024-03-04	t	\N
45	3	TestUser	this is for buying	40.00	2024-03-04	f	\N
46	3	TestUser	this is for buying	40.00	2024-03-04	f	\N
47	3	TestUser	expense is updated	40.00	2024-03-04	f	\N
50	1	TestUser	this is for buying meat	40.00	2024-03-04	f	\N
52	1	TestUser	this is for buying meat	40.00	2024-03-04	f	\N
7	1	TestUser	this is for buying meat	40.00	2024-03-04	f	\N
33	2	TestUser	this is for buying 	40.00	2024-03-04	f	\N
35	1	TestUser	this is for buying meat	40.00	2024-03-04	f	\N
38	2	amul	\N	30.00	2025-01-08	f	\N
41	1	reliance	\N	50.00	2025-01-06	f	\N
42	1	reliance	\N	45.00	2025-01-08	f	\N
49	1	reliance	\N	45.00	2025-01-14	f	\N
51	1	reliance	\N	45.00	2025-01-07	f	\N
53	1	reliance	\N	45.00	2025-01-14	f	\N
54	1	reliance	\N	45.00	2025-01-09	f	\N
55	1	reliance	\N	45.00	2025-01-07	f	\N
40	5	mcdonalds	\N	500.00	2025-01-07	f	\N
48	6	amul	\N	50.00	2025-01-20	f	\N
3	1	owner	expense is updated	40.00	2024-03-04	f	\N
71	1	fruit vendor	supermarket	500.00	2025-02-19	t	\N
72	8	microsoft	new halo game	1200.00	2025-01-15	t	\N
73	3	METRO	metro	45.00	2025-01-06	t	\N
74	3	METRO	metro	45.00	2025-02-12	t	\N
57	5	mcdonalds	burger	500.00	2025-01-13	f	\N
37	3	metro	\N	45.00	2025-01-14	f	\N
39	3	metro	\N	45.00	2025-01-14	f	\N
64	1	reliance	apple	45.00	2025-01-08	f	\N
63	1	reliance	apple	45.00	2025-01-08	f	\N
56	1	reliance	milk	45.00	2025-01-31	f	\N
60	2	amul	milk	90.00	2025-01-15	f	\N
61	6	mcdonalds	i bought a burger	500.00	2025-01-14	f	4WT9ISKR
67	6	bakery	veg puff	40.00	2025-01-14	t	QD7WP5PT
70	5	test	testingg	45.00	2025-01-15	f	N6R2RNH2
69	6	reliance	lays	20.00	2025-01-20	t	P9PFVAQ3
65	1	fruit vendor	grapes	50.00	2025-01-13	f	2UPF03JC
76	1	big save	fruits	10000.00	2025-01-24	f	VK8KWSNW
66	9	apollo	cold medicine	45.00	2025-01-13	t	V4ZGNCQJ
68	5	labonel	dinner	5000.00	2025-01-15	f	AOUUD53U
62	1	reliance	apple	45.00	2025-01-08	f	DYT6GYIZ
77	2	reliance	milk	50.00	2025-01-13	t	9YPB4B9X
78	2	amul	milk	50.00	2025-01-20	t	402COUHY
75	2	reliance	rice	54.00	2025-01-17	f	ATW86GX0
79	8	xbox	bought a new xbox	5000.00	2025-02-17	t	76W82ML7
80	2	amul	milk	50.00	2025-02-06	f	NE1X4SW6
\.


--
-- Name: categories_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categories_id_seq', 7, true);


--
-- Name: category_type_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.category_type_id_seq', 15, true);


--
-- Name: expenses_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.expenses_id_seq', 80, true);


--
-- Name: category categories_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT categories_name_key UNIQUE (name);


--
-- Name: category categories_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);


--
-- Name: category_type category_type_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category_type
    ADD CONSTRAINT category_type_pkey PRIMARY KEY (id);


--
-- Name: expense expenses_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expense
    ADD CONSTRAINT expenses_pkey PRIMARY KEY (id);


--
-- Name: category_type category_type_category_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category_type
    ADD CONSTRAINT category_type_category_id_fkey FOREIGN KEY (category_id) REFERENCES public.category(id) ON DELETE CASCADE;


--
-- Name: expense expenses_type_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expense
    ADD CONSTRAINT expenses_type_id_fkey FOREIGN KEY (type_id) REFERENCES public.category_type(id);


--
-- PostgreSQL database dump complete
--

