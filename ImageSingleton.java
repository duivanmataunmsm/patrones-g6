import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class ImageSingleton {
    private static ImageSingleton instance = null;
    private static HashMap<String, String> paths;

    ImageSingleton() { }

    /**
     * Retorna la instancia de la clase y si es null crea una nueva
     * @return instance
     */
    public static ImageSingleton getInstance() {
        if (instance == null) {
            getPaths();
            return new ImageSingleton();
        }
        return instance;
    }
    /**
     * Retorna la coleccion de imagenes
     * @return paths
     */
    public HashMap<String, String>  getImages() {

        return paths;
    }
    /**
     * Asigna una coleccion con las imagenes de todas las piezas del ajedrez
     */
    private static void getPaths() {

        //@TODO: obtener de apirest
        HashMap<String, String> data = new HashMap<String, String>(){{
            put("BISHOP_WHITE", "chessImages/WhiteBishop.gif");
            put("BISHOP_BLACK", "chessImages/BlackBishop.gif");
            put("KING_WHITE", "chessImages/WhiteKing.gif");
            put("KING_BLACK", "chessImages/BlackKing.gif");
            put("KNIGHT_WHITE", "chessImages/WhiteKnight.gif");
            put("KNIGHT_BLACK", "chessImages/BlackKnight.gif");
            put("PAWN_WHITE", null);
            put("PAWN_BLACK", "chessImages/BlackPawn.gif");
            put("QUEEN_BLACK", "chessImages/BlackQueen.gif");
            put("QUEEN_WHITE", "chessImages/WhiteQueen.gif");
            put("ROOK_WHITE", "chessImages/WhiteRook.gif");
            put("ROOK_BLACK", null);
            put("DEFAULT", "chessImages/default-Unassigned.gif");
        }};

        paths = PathAdapter.adapter(data);
        System.out.println(paths);
    }

    private synchronized static String getImagesFromApiRestService(String targetURL, String urlParameters) {
        HttpURLConnection connection = null;

        try {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");

            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-ES");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            System.out.println(response.toString());
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public PieceImageHandler getPieceImage(ChessGamePiece piece) {
        String imageName = "";
        if ( piece.getColorOfPiece() == ChessGamePiece.WHITE ){
            imageName = piece.getPieceName() + "_WHITE";
        } else if ( piece.getColorOfPiece() == ChessGamePiece.BLACK ){
            imageName = piece.getPieceName() + "_BLACK";
        }

        if( paths.containsKey(imageName) && paths.get(imageName)!=null){
            return new PieceImage(paths.get(imageName));
        }
        return new PieceImageNull();
    }
}
