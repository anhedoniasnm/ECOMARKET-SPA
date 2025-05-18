CREATE TABLE CategoriaProducto (
	idCategoria INT AUTO_INCREMENT PRIMARY KEY,
    nombreCategoria VARCHAR(100) NOT NULL,
    descripcionCategoria TEXT
);

CREATE TABLE producto (
	idProducto INT AUTO_INCREMENT PRIMARY KEY,
    nombreProducto VARCHAR (100),
    marcaProducto VARCHAR (30),
    precioProducto DECIMAL (10, 2),
    stockProducto INT DEFAULT 0,
    idCategoria INT,
    estadoProducto BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (idCategoria) REFERENCES CategoriaProducto (idCategoria) ON DELETE SET NULL
);

CREATE TABLE Cliente (
	idCliente INT AUTO_INCREMENT PRIMARY KEY,
    nombreCliente VARCHAR (100) NOT NULL,
    emailCliente VARCHAR (100) UNIQUE NOT NULL,
    direccionCliente TEXT,
    telefono VARCHAR (20)
);

CREATE TABLE Pedido (
	idPedido INT AUTO_INCREMENT PRIMARY KEY,
    idCliente INT,
    fechaPedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    totalPedido DECIMAL (10, 2) NOT NULL,
    estadoPedido VARCHAR (20) DEFAULT 'Pendiente',
    FOREIGN KEY (idCliente) REFERENCES Cliente (idCliente)
);

CREATE TABLE DetallePedido(
	idDetallePedido INT AUTO_INCREMENT PRIMARY KEY,
    idPedido INT,
    idProducto INT,
    cantidadProducto INT NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (idPedido) REFERENCES Pedido (idPedido),
    FOREIGN KEY (idProducto) REFERENCES producto (idProducto)
);