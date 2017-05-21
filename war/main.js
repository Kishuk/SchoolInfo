var apiRoot = 'http://localhost:8888/_ah/api'
var apiName = 'webservice'
function apiLoad() {
  
  gapi.client.load(apiName, 'v1', callback, apiRoot);
}
function callback() {
  
  
  var path = `${apiRoot}/${apiName}/v1/map_string_stringcollection`
  var params = {}
  params[ 'path' ] = path
  params[ 'method' ] = 'GET'
  gapi.client.request(params).execute(function (resp) {

    console.log(resp)
    var str = "<table>"
    for(var i=0;i<resp.items.length;i++) {
      var s = "<tr>"
      var keys = Object.keys(resp.items[i])
      keys.forEach(function(key) {
        var strd = '<td>'+resp.items[i][key]+'</td>'
        s = s + strd
      })
      s = s + "</tr>"
      str = str+s
    }
    str = str+"</table>"
    document.getElementById("app").innerHTML = (str)
    
    
  }
  )
  
}