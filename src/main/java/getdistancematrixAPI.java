import java.util.*;
import java.io.InvalidObjectException;
import java.io.IOException;
import java.net.*;
import java.net.URI;
import java.net.HttpURLConnection;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;

public class getdistancematrixAPI{
    private static final String API_KEY = "AIzaSyA8_CvbqF44kPnpqzkR9W-yxTqhclHjCZg";
    public static float [][] distance;
    public static float [][] times;

public static  void getData(String source, String destination) throws Exception{
    var url ="https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + source + "&destinations=" + destination + "&key=" + API_KEY;
    var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
    var client = HttpClient.newBuilder().build();
    var response = client.send(request, HttpResponse.Bodyhandlers.ofString().body());

    System.out.println(response);
}

public static void main (String[] args){
    String source = "Tehran";
    String destination = "Shiraz";
    getData(source, destination);

}