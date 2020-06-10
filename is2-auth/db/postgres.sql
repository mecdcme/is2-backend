-- DROP DATABASE postgres;

CREATE DATABASE postgres
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Italian_Italy.1252'
    LC_CTYPE = 'Italian_Italy.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE postgres
    IS 'default administrative connection database';
    
  
CREATE TABLE public."ROLES" (
    id bigint NOT NULL,
    "NAME" text
);


ALTER TABLE public."ROLES" OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16398)
-- Name: USERS; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."USERS" (
    id bigint NOT NULL,
    username text,
    name text,
    role bigint,
    password text
);


ALTER TABLE public."USERS" OWNER TO postgres;

--
-- TOC entry 2693 (class 2606 OID 16397)
-- Name: ROLES USER_ROLES_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."ROLES"
    ADD CONSTRAINT "USER_ROLES_pkey" PRIMARY KEY (id);


--
-- TOC entry 2695 (class 2606 OID 16402)
-- Name: USERS pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."USERS"
    ADD CONSTRAINT pk PRIMARY KEY (id);


--
-- TOC entry 2696 (class 2606 OID 16403)
-- Name: USERS rolefk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."USERS"
    ADD CONSTRAINT rolefk FOREIGN KEY (role) REFERENCES public."ROLES"(id);


-- Completed on 2020-03-19 19:16:29

--
-- PostgreSQL database dump complete
--


INSERT INTO public."ROLES" (id, "NAME") VALUES (1, 'ADMIN');
INSERT INTO public."ROLES" (id, "NAME") VALUES (2, 'GUEST');


--
-- TOC entry 2824 (class 0 OID 16398)
-- Dependencies: 204
-- Data for Name: USERS; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."USERS" (id, username, name, role, password) VALUES (1, 'admin@is2.it', 'Administrator', 1, '$2a$10$VB7y/I.oD16QBVaExgH1K.VEuBUKRyXcCUVweUGhs1vDl0waTQPmC');
INSERT INTO public."USERS" (id, username, name, role, password) VALUES (2, 'user@is2.it', 'User', 2, '$2a$10$yK1pW21E8nlZd/YcOt6uB.n8l36a33RP3/hehbWFAcBsFJhVKlZ82');

  
    