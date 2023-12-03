create table "order"."t_order"
(
    "id"         bigserial not null,
    "order_date" timestamp(6),
    primary key ("id")
);
create table "order"."t_order_item"
(
    "purchased_quantity" integer,
    "id"                 bigserial not null,
    "order_id"           bigint    not null,
    "stock_id"           bigint,
    primary key ("id")
);
alter table if exists "order"."t_order_item"
    add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order"
(
    "id"         bigserial not null,
    "order_date" timestamp(6),
    primary key ("id")
);
create table "order"."t_order_item"
(
    "purchased_quantity" integer,
    "id"                 bigserial not null,
    "order_id"           bigint    not null,
    "stock_id"           bigint,
    primary key ("id")
);
alter table if exists "order"."t_order_item"
    add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order"
(
    "id"         bigserial not null,
    "order_date" timestamp(6),
    primary key ("id")
);
create table "order"."t_order_item"
(
    "purchased_quantity" integer,
    "id"                 bigserial not null,
    "order_id"           bigint    not null,
    "stock_id"           bigint,
    primary key ("id")
);
alter table if exists "order"."t_order_item"
    add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order"
(
    "id"         bigserial not null,
    "order_date" timestamp(6),
    primary key ("id")
);
create table "order"."t_order_item"
(
    "purchased_quantity" integer,
    "id"                 bigserial not null,
    "order_id"           bigint    not null,
    "stock_id"           bigint,
    primary key ("id")
);
alter table if exists "order"."t_order_item"
    add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order"
(
    "id"         bigserial not null,
    "order_date" timestamp(6),
    primary key ("id")
);
create table "order"."t_order_item"
(
    "purchased_quantity" integer,
    "id"                 bigserial not null,
    "order_id"           bigint    not null,
    "stock_id"           bigint,
    primary key ("id")
);
alter table if exists "order"."t_order_item"
    add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order"
(
    "id"         bigserial not null,
    "order_date" timestamp(6),
    primary key ("id")
);
create table "order"."t_order_item"
(
    "purchased_quantity" integer,
    "id"                 bigserial not null,
    "order_id"           bigint    not null,
    "stock_id"           bigint,
    primary key ("id")
);
alter table if exists "order"."t_order_item"
    add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order"
(
    "id"         bigserial not null,
    "order_date" timestamp(6),
    primary key ("id")
);
create table "order"."t_order_item"
(
    "purchased_quantity" integer,
    "id"                 bigserial not null,
    "order_id"           bigint    not null,
    "stock_id"           bigint,
    primary key ("id")
);
alter table if exists "order"."t_order_item"
    add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
create table "order"."t_order" ("id" bigserial not null, "order_date" timestamp(6), primary key ("id"));
create table "order"."t_order_item" ("purchased_quantity" integer, "id" bigserial not null, "order_id" bigint not null, "stock_id" bigint, primary key ("id"));
alter table if exists "order"."t_order_item" add constraint "FK33svw26b469fbxsunugikuqjl" foreign key ("order_id") references "order"."t_order";
