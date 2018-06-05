const {app, BrowserWindow} = require('electron')
const path = require('path')
const url = require('url')

// Keep a global reference of the window object, if you don't, the window will
// be closed automatically when the JavaScript object is garbage collected.
let win

function createWindow () {
  // Create the browser window.
  win = new BrowserWindow({width: 800, height: 600})

  // and load the index.html of the app.
  win.loadURL(url.format({
    pathname: path.join(__dirname, 'index.html'),
    protocol: 'file:',
    slashes: true
  }))

  // Open the DevTools.
  win.webContents.openDevTools()

  // Emitted when the window is closed.
  win.on('closed', () => {
    // Dereference the window object, usually you would store windows
    // in an array if your app supports multi windows, this is the time
    // when you should delete the corresponding element.
    win = null
  })
}

// This method will be called when Electron has finished
// initialization and is ready to create browser windows.
// Some APIs can only be used after this event occurs.
app.on('ready', createWindow)

// Quit when all windows are closed.
app.on('window-all-closed', () => {
  // On macOS it is common for applications and their menu bar
  // to stay active until the user quits explicitly with Cmd + Q
  if (process.platform !== 'darwin') {
    app.quit()
  }
})

app.on('activate', () => {
  // On macOS it's common to re-create a window in the app when the
  // dock icon is clicked and there are no other windows open.
  if (win === null) {
    createWindow()
  }
})
function httpGet(theUrl) {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", theUrl, false);
    xmlHttp.setRequestHeader('Content-Type', 'application/json');
    xmlHttp.send(null);
    console.log(xmlHttp.responseText);

    return xmlHttp.responseText;
}
function income()
{
    var input = document.getElementById("userInput").value;
    var urlvariable;
    urlvariable = "text";
    var JsonNo='{"income": "'+input+'"}';
  
    URL = "http://localhost:8989/Wallet/postincome";  //Your URL
    
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = callbackFunction(xmlhttp);
    xmlhttp.open("POST", URL, false);
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.setRequestHeader('Authorization', 'Basic ' + window.btoa('apiusername:apiuserpassword')); //in prod, you should encrypt user name and password and provide encrypted keys here instead 
    xmlhttp.onreadystatechange = callbackFunction(xmlhttp);
    xmlhttp.send(JsonNo);
    var jsonObj= JSON.parse(xmlhttp.responseText);
    document.getElementById("someInput").innerHTML = "Income:    "+ jsonObj.income+".00";	 
}
function callbackFunction(xmlhttp) 
{
    //alert(xmlhttp.responseXML);
}
function myFunction() {
    confirm("The Value Is Added!");
}
function openNav() {
    document.getElementById("mySidenav").style.width = "340.16px";
    document.getElementById("main").style.marginLeft = "340.16px";
}
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
}
function food()
{
    var input = document.getElementById("userInput").value;
    var JsonNo='{"food":"'+input+'"}';

    URL = "http://localhost:8989/Wallet/postfood";  //Your URL
    
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = callbackFunction(xmlhttp);
    xmlhttp.open("POST", URL, false);
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.setRequestHeader('Authorization', 'Basic ' + window.btoa('apiusername:apiuserpassword')); //in prod, you should encrypt user name and password and provide encrypted keys here instead 
    xmlhttp.onreadystatechange = callbackFunction(xmlhttp);
    xmlhttp.send(JsonNo);
    var jsonObj= JSON.parse(xmlhttp.responseText);
    document.getElementById("someInput").innerHTML = "Food:    "+ jsonObj.income+".00";	 
}
function health()
{
    var input = document.getElementById("userInput").value;
    var JsonNo='{"health":"'+input+'"}';

    URL = "http://localhost:8989/Wallet/posthealth";  //Your URL
    
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = callbackFunction(xmlhttp);
    xmlhttp.open("POST", URL, false);
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.setRequestHeader('Authorization', 'Basic ' + window.btoa('apiusername:apiuserpassword')); //in prod, you should encrypt user name and password and provide encrypted keys here instead 
    xmlhttp.onreadystatechange = callbackFunction(xmlhttp);
    xmlhttp.send(JsonNo);
    var jsonObj= JSON.parse(xmlhttp.responseText);
    document.getElementById("someInput").innerHTML = "Food:    "+ jsonObj.income+".00";	 
}
function study()
{
    var input = document.getElementById("userInput").value;
    var JsonNo='{"study":"'+input+'"}';

    URL = "http://localhost:8989/Wallet/poststudy";  //Your URL
    
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = callbackFunction(xmlhttp);
    xmlhttp.open("POST", URL, false);
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.setRequestHeader('Authorization', 'Basic ' + window.btoa('apiusername:apiuserpassword')); //in prod, you should encrypt user name and password and provide encrypted keys here instead 
    xmlhttp.onreadystatechange = callbackFunction(xmlhttp);
    xmlhttp.send(JsonNo);
    var jsonObj= JSON.parse(xmlhttp.responseText);
    document.getElementById("someInput").innerHTML = "Food:    "+ jsonObj.income+".00";	 
}
function transport()
{
    var input = document.getElementById("userInput").value;
    var JsonNo='{"transport":"'+input+'"}';

    URL = "http://localhost:8989/Wallet/posttransport";  //Your URL
    
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = callbackFunction(xmlhttp);
    xmlhttp.open("POST", URL, false);
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.setRequestHeader('Authorization', 'Basic ' + window.btoa('apiusername:apiuserpassword')); //in prod, you should encrypt user name and password and provide encrypted keys here instead 
    xmlhttp.onreadystatechange = callbackFunction(xmlhttp);
    xmlhttp.send(JsonNo);
    var jsonObj= JSON.parse(xmlhttp.responseText);
    document.getElementById("someInput").innerHTML = "Food:    "+ jsonObj.income+".00";	 
}
// In this file you can include the rest of your app's specific main process
// code. You can also put them in separate files and require them here.