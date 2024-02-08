
//FUNCIONES PARA MOSTRAR Y OCULTAR FORMULARIOS
window.onbeforeunload = function() 
{
  // Redirige al usuario a la página del formulario después de recargar
  window.location.href = '/index/';
};
function displayFormReg()
 {
   const formIS = document.querySelector("#section-form #formIS");
   const formReg = document.querySelector("#section-form #formReg");
   const formOlv = document.querySelector("#section-form #formOlv");
   
   formOlv.style.display = "none";
   formIS.style.display = "none";
   formReg.style.display="block";
 }

 function displayFormOlv()
 {
    const formIS = document.querySelector("#section-form #formIS");
 
    const formOlv = document.querySelector("#section-form #formOlv");
   
    formOlv.style.display = "block";
    formIS.style.display = "none";
  
  }

 function displayFormIS()
 {
  const formIS = document.querySelector("#section-form #formIS");

  const formOlv = document.querySelector("#section-form #formOlv");
  const formCon = document.querySelector("#section-form #formCon");
  const tabla = document.querySelector("#section-form #tabla");
  let res = document.getElementById("response");
  let btn1 = document.getElementById("btnnn");

  let etiquetas = document.querySelectorAll('form[name="formReg"] label');
  etiquetas.forEach(function (etiqueta) 
  {
    let campo = etiqueta.querySelector('input[required]');
    if (campo) 
    {
      campo.value = '';
   }
  });

  let etiquetas1 = document.querySelectorAll('form[name="formCon"] label');
  etiquetas1.forEach(function (etiqueta) 
  {
    let campo = etiqueta.querySelector('input[required]');
    if (campo) 
    {
      campo.value = '';
    }
    });
  
  let formulariOlv = document.getElementById("formOlv");
  let etiquetaUsername = formulariOlv.querySelector('input[name="user"]');
  //etiquetaUsername.value = " ";
          
   
  formOlv.style.display = "none";
  formReg.style.display="none";
  formIS.style.display = "block"; 
  tabla.style.display = "none"; 
  formCon.style.display = "none";
  res.style.display = "none";
  btn1.style.display = "none";
}

//FUNCION PARA INICIAR SESION 

function Iniciarsesion()
{
      window.location.href = '/users';
        let formularioIS = document.getElementById("formIS");
        let etiquetaUsername = formularioIS.querySelector('input[name="username"]');
        let etiquetaPasswd = formularioIS.querySelector('input[name="passwd"]');
        etiquetaUsername.value = "";
        etiquetaPasswd.value = "";

        let formIS = document.querySelector("#section-form #formIS");
        formIS.style.display = "none";
        let tabla = document.querySelector("#tabla");
        tabla.style.display = "block";
        

} 

function INICIO()
 {
  window.location.href = '/index';
 }

 
 function ADMIN()
 {
  window.location.href = '/admin';
 }

 function OPERATIVO()
 {
  window.location.href = '/Operativo';
 }
 function REGISTRA()
 {
  window.location.href = '/registra';
 }
 function API()
 {
  window.location.href = '/cargar';
 }

  //FUNCION QUE REGISTRA USUARIOS
  function registerUser() 
  {
        //window.location.href = '/registrar';
        
        displayFormIS();
        console.log("Este es un mensaje de prueba.");
  }


  //GESTION DEL CARRITO DE COMPRAS
  let carrito = JSON.parse(localStorage.getItem('carrito')) || [];

  // GESTION DEL CARRITO DE COMPRAS
  function addToCart(name, thumbnail) 
  {
      alert("Se agrego: " + name + " exitosamente al carrito");
      
      carrito.push({ name: name, thumbnail: thumbnail });

      localStorage.setItem('carrito', JSON.stringify(carrito));

  }

  function CARRITO()
  {
    alert("Trabajando en ello");
    window.location.href = '/carrito';
  }
  
  function BUSQUEDA()
  {
    alert("Trabajando en ello");
    window.location.href = '/cargar';
  }

  function MENU()
  {
    window.location.href = '/vistal';
  }

  function LISTA()
  {
    window.location.href = '/vistal';
  }


  function CIERRA()
  {
    alert("Cerrando sesion");
    window.location.href = '/cerrar';
  }

  function CIERRA2()
  {
    alert("Cerrando sesion");
    window.location.href = '/cerrar2';
  }

  // Obtener carrito desde localStorage
  function obtenerCarrito () {
    const carritoString = localStorage.getItem('carrito');
  
    if (carritoString) {
      const carrito = JSON.parse(carritoString);
      return carrito;
    }
  
    return null;
  };

 // Función para mostrar el carrito en la interfaz de usuario
function mostrarCarrito() {
  const carrito = obtenerCarrito();
  const carritoContainer = document.getElementById('carrito-container');

  if (carrito && carrito.length > 0) {
    carritoContainer.innerHTML = ''; // Limpiar el contenedor antes de agregar elementos

    // Crear un contenedor de fila para organizar las imágenes
    let rowContainer;

    carrito.forEach((item, index) => {
      // Crear elementos HTML para cada item del carrito
      const itemElement = document.createElement('div');
      itemElement.className = 'marg22';

      // Agregar la imagen y el botón
      itemElement.innerHTML = `<img class="img-thumbnail" src="${item.thumbnail}" alt="${item.name}" >
                               <p class="coltxt11" class="form">${item.name}</p>
                               <button onclick="eliminarDelCarrito('${item.name}')"><img class="imgcar" src="https://thumbs.dreamstime.com/b/ilustraci%C3%B3n-vectorial-de-icono-basura-aislada-en-fondo-transparente-vector-s%C3%ADmbolo-signo-aislado-estilo-negro-y-blanco-207441253.jpg" alt="111"></button>`;

      // Crear una nueva fila después de cada 5 elementos
      if (index % 4 === 0) {
        rowContainer = document.createElement('div');
        rowContainer.className = 'carrito-row';
        carritoContainer.appendChild(rowContainer);
      }

      // Agregar el elemento al contenedor de fila
      rowContainer.appendChild(itemElement);
    });
  } else {
    // Manejar el caso cuando el carrito esté vacío
    carritoContainer.innerHTML = '<p>El carrito está vacío</p>';
  }
}


// Función para eliminar un elemento del carrito

function eliminarDelCarrito(name) {
  let carrito = obtenerCarrito();

  
  const index = carrito.findIndex(item => item.name === name);

  if (index !== -1) {

    carrito.splice(index, 1);
    localStorage.setItem('carrito', JSON.stringify(carrito));
    mostrarCarrito();
  }
}
  
  // Enviar datos al servidor
  const enviarDatosAlServidor = async () => {
    const carrito = obtenerCarrito();
  
    if (carrito) {
      
      const url = 'http://localhost:3000/infoc';
      const data = { carrito };
      console.log(data);
  
      try {
        const response = await fetch(url, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(data),
        });
 
        const responseData = await response.json();
        console.log(responseData);
        alert("Carrito enviado");
        localStorage.clear();
      } catch (error) {
        alert("Problema al enviar carrito");
        localStorage.clear();
        console.log(error);
      }
    }
  };
  
  function eleccion()
  {
    let select = document.getElementById("useredit");
    let selectedValue = select.options[select.selectedIndex].value;


    switch (selectedValue) 
    {
      case "username":
        {
          let formun = document.querySelector("#section-form #formnombre");
          formun.style.display = "block";
          let formue = document.querySelector("#section-form #formcorreo");
          formue.style.display = "none";
          let formuq = document.querySelector("#section-form #formpregunta");
          formuq.style.display = "none";
          let formua = document.querySelector("#section-form #formrespuesta");
          formua.style.display = "none";
          let formup = document.querySelector("#section-form #formnivel");
          formup.style.display = "none";
          break;
        }
      case "useremail":
        {
          let formun = document.querySelector("#section-form #formnombre");
          formun.style.display = "none";
          let formue = document.querySelector("#section-form #formcorreo");
          formue.style.display = "block";
          let formuq = document.querySelector("#section-form #formpregunta");
          formuq.style.display = "none";
          let formua = document.querySelector("#section-form #formrespuesta");
          formua.style.display = "none";
          let formup = document.querySelector("#section-form #formnivel");
          formup.style.display = "none";
          break;
        }
      case "userquestion":
        {
          let formun = document.querySelector("#section-form #formnombre");
          formun.style.display = "none";
          let formue = document.querySelector("#section-form #formcorreo");
          formue.style.display = "none";
          let formuq = document.querySelector("#section-form #formpregunta");
          formuq.style.display = "block";
          let formua = document.querySelector("#section-form #formrespuesta");
          formua.style.display = "none";
          let formup = document.querySelector("#section-form #formnivel");
          formup.style.display = "none";
          break;
        }
      case "useranswer":
        {
          let formun = document.querySelector("#section-form #formnombre");
          formun.style.display = "none";
          let formue = document.querySelector("#section-form #formcorreo");
          formue.style.display = "none";
          let formuq = document.querySelector("#section-form #formpregunta");
          formuq.style.display = "none";
          let formua = document.querySelector("#section-form #formrespuesta");
          formua.style.display = "block";
          let formup = document.querySelector("#section-form #formnivel");
          formup.style.display = "none";
          break;
        }
      case "userposition":
        {
          let formun = document.querySelector("#section-form #formnombre");
          formun.style.display = "none";
          let formue = document.querySelector("#section-form #formcorreo");
          formue.style.display = "none";
          let formuq = document.querySelector("#section-form #formpregunta");
          formuq.style.display = "none";
          let formua = document.querySelector("#section-form #formrespuesta");
          formua.style.display = "none";
          let formup = document.querySelector("#section-form #formnivel");
          formup.style.display = "block";
          break;
        }
    }
  }
 
  