require("dotenv").config();

const LibroRoutes = require("./routes/LibroRoutes");
const CategoriaRoutes = require("./routes/CategoriaRouter");
const AutorRoutes = require("./routes/AutorRouter");

const express = require("express");
const cors = require("cors");
const app = express();
const PORT = process.env.PORT || 3000;
app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.use("/api/libros", LibroRoutes);
app.use("/api/categorias", CategoriaRoutes);
app.use("/api/autores", AutorRoutes);

app.get("/", (req, res) => {
  res.json({
    mensaje: "API DE BIBLIOTECA - CRUD LIBROS",
  });
});
app.listen(PORT, () => {
  console.log("SERVIDOR CORRIENDO EXITOSAMENTE");
  console.log(`----> PUERTO: ${PORT}`);
});
