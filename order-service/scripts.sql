
CREATE TABLE public.orders
(
    id bigint NOT NULL,
    create_date timestamp without time zone,
    customer_id bigint,
    delivery_method character varying(255),
    shipping_charges double precision,
    status character varying(255),
    sub_total double precision,
    tax double precision,
    total double precision,
    update_date timestamp without time zone,
    shipping_address_id bigint,
    CONSTRAINT orders_pkey PRIMARY KEY (id),
    CONSTRAINT FOREIGN KEY (shipping_address_id)
        REFERENCES public.shipping_address (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

CREATE TABLE public.items
(
    id bigint NOT NULL,
    name character varying(255),
    qty integer,
    CONSTRAINT items_pkey PRIMARY KEY (id)
)

CREATE TABLE public.orders_items
(
    order_id bigint NOT NULL,
    items_id bigint NOT NULL,
    CONSTRAINT UNIQUE (items_id),
    CONSTRAINT FOREIGN KEY (order_id)
        REFERENCES public.orders (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT OREIGN KEY (items_id)
        REFERENCES public.items (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

CREATE TABLE public.payment
(
    id bigint NOT NULL,
    billing_address_line_1 character varying(255),
    billing_address_line_2 character varying(255),
    billing_city character varying(255),
    billing_state character varying(255),
    billing_zip character varying(255),
    confirmation_number character varying(255),
    payment_date character varying(255),
    payment_method character varying(255),
    CONSTRAINT payment_pkey PRIMARY KEY (id)
)

CREATE TABLE public.orders_payments
(
    order_id bigint NOT NULL,
    payments_id bigint NOT NULL,
    CONSTRAINT UNIQUE (payments_id),
    CONSTRAINT FOREIGN KEY (order_id)
        REFERENCES public.orders (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT FOREIGN KEY (payments_id)
        REFERENCES public.payment (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

CREATE TABLE public.shipping_address
(
    id bigint NOT NULL,
    address_line_1 character varying(255),
    address_line_2 character varying(255),
    city character varying(255),
    state character varying(255),
    zip character varying(255),
    CONSTRAINT shipping_address_pkey PRIMARY KEY (id)
)
