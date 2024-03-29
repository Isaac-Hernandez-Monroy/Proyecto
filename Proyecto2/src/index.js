import express from 'express';
import hbs from 'hbs';
import cookieParser from 'cookie-parser';

import { dirname } from 'path';
import { fileURLToPath } from 'url';

import indexRoutes from './routes/index.routes.js';
import usersRoutes from './routes/users.routes.js';
import apiRoutes from './routes/users.routes.js';

// obtiene la ruta raiz del proyecto
const PORT = 3000;

// Instancia para el servidor HTTP de la aplicación
const app = express();
app.use(cookieParser());

const __dirname = dirname(fileURLToPath(import.meta.url));
console.log(__dirname);

// Se habilita el uso de routes users.
app.use(express.urlencoded({extended:true}));
app.use(express.json());

// se establece la ruta para los recursos estáticos
app.use(express.static(__dirname + "/public"));


// configuración de hbs como motor de plantillas
app.set("view engine", "hbs");
app.set("views", __dirname+"/views");
hbs.registerPartials(__dirname + '/views/partials', function (err) {});

/*
app.use((req, res, next) => {
  res.status(404).render("error404", {
      titulo: "404",
      descripcion: "Página no encontrada"
  })
})*/


//app.use(express.json());
app.use (indexRoutes);
app.use (usersRoutes);
app.use(apiRoutes);


app.listen(PORT,()=>{
  console.log(`Servidor ejecutandose en el puerto ${PORT}`);  
});


