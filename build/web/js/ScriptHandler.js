
//common function for backend call*
function handlePost(actionId, fieldNames, fieldValues){
    debugger;
    var response = null;
    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
      if (this.status == 200) {
        response = this.responseText;
      }
    };
  xhttp.open("POST", "RequestProcessor", false);
  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  var postData = 'actionId=' + actionId + '&fieldNames=' + fieldNames + '&fieldValues=' + fieldValues;
  xhttp.send(postData);
  return response;
  
}