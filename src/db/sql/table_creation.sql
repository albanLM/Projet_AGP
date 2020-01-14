CREATE TABLE TransportMethod (
	id SERIAL PRIMARY KEY,
	name VARCHAR(100),
	speed INTEGER,
	pricePerKm FLOAT
);

CREATE TABLE Coordinates (
	id SERIAL PRIMARY KEY,
	x INTEGER,
	y INTEGER
);

CREATE TABLE Place (
	id SERIAL PRIMARY KEY,
	name VARCHAR(100),
	descriptionFile VARCHAR(100),
	id_coord BIGINT UNSIGNED,
	CONSTRAINT fk_place_coord FOREIGN KEY (id_coord) REFERENCES Coordinates(id)
);

CREATE TABLE Visit (
	id SERIAL PRIMARY KEY,
	visitTime FLOAT,
	price FLOAT,
	id_place BIGINT UNSIGNED,
	CONSTRAINT fk_visit_place FOREIGN KEY (id_place) REFERENCES Place(id)
);

CREATE TABLE Hotel (
	id_place BIGINT UNSIGNED PRIMARY KEY,
	pricePerDay FLOAT,
	id_beach BIGINT UNSIGNED,
	CONSTRAINT fk_hotel_place FOREIGN KEY (id_place) REFERENCES Place(id),
	CONSTRAINT fk_hotel_beach FOREIGN KEY (id_beach) REFERENCES Place(id)
);