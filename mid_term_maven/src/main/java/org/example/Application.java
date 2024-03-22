package org.example;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;

public class Application {



    protected InputDevice userInput ;
    protected OutputDevice programOutput;

    protected Catalog list = new Catalog();

    protected JsonFile json = new JsonFile();

    public Application(InputDevice userInput, OutputDevice programOutput){
        this.userInput = userInput;
        this.programOutput = programOutput;
    }

    //run as admin
    public void run() throws IOException, InterruptedException, ClassNotFoundException {
        //update list of products
        ArrayList<JSONObject> listFromFile = programOutput.readFromFile();
        list.updateObjList(listFromFile);

        boolean run = true;
        while (run){

            //ask for user input
            programOutput.printMessage("Choose action: \n1.search a product;\n2.add a Movie;\n3.add a Series;\n4.display list of products;\n5.delete a product;\n6.test code;\n7.add user \n8.update user role\n9.delete user\n10.display users\n0.exit program.\n ");
            int userChoise = userInput.inputInteger();
            userInput.inputString();
            programOutput.printMessage("\n");
            DatabaseLink data = new DatabaseLink();

            switch(userChoise){

                case 1://search for product
                    programOutput.printMessage("Product name: \n");
                    String productName = userInput.inputString();

                    if (data.checkSpecificObjectFromDB(productName)
                    ) {
                        programOutput.printMessage("Product "+ productName + " found in the collection.\n");

                    } else {
                        programOutput.printMessage("Product not found.\n");

                    }
                    programOutput.printMessage("\n");
                    break;

                case 2://add movie to list of products

                    //construct movie product
                    programOutput.printMessage("Title of Movie: \n");
                    String titleMovie = userInput.inputString();
                    programOutput.printMessage("Year of launching: \n");
                    int yearOfAppearanceMovie = userInput.inputInteger();
                    programOutput.printMessage("Duration of Movie in minutes: \n");
                    int durationOfMovie = userInput.inputInteger();
                    userInput.inputString();

                    programOutput.printMessage("Director of the Movie: \n");
                    String directorOfMovie = userInput.inputString();
                    programOutput.printMessage("Age restriction: \n");
                    int ageRestrictionMovie = userInput.inputInteger();
                    programOutput.printMessage("Price: \n");
                    int priceForBuy = userInput.inputInteger();
                    userInput.inputString();

                    programOutput.printMessage("Genre: \n");
                    String genreMovie = userInput.inputString();
                    String typeM = "Movie";
                    Product newMovieProduct = new Movie(titleMovie, yearOfAppearanceMovie,  durationOfMovie,  directorOfMovie, ageRestrictionMovie, priceForBuy,genreMovie, typeM );

                   //update list of products
                    list.addToList(newMovieProduct);
                    data.insertProductToDB( newMovieProduct);
                    programOutput.printMessage("Movie was added to the collection.\n");
                    programOutput.printMessage("\n");
                    break;


                case 3://add series to product list

                    //construct series product
                    programOutput.printMessage("Title of Series: \n");
                    String titleSeries = userInput.inputString();
                    programOutput.printMessage("Year of launching: \n");
                    int yearOfAppearanceSeries = userInput.inputInteger();
                    programOutput.printMessage("Duration of an episode in minutes: \n");
                    int durationOfEpisode = userInput.inputInteger();
                    userInput.inputString(); // Consume the newline character
                    programOutput.printMessage("Director of the Series: \n");
                    String directorSeries = userInput.inputString();
                    programOutput.printMessage("Age restriction: \n");
                    int ageRestrictionSeries = userInput.inputInteger();
                    programOutput.printMessage("Standard price per year for renting: \n");
                    int priceRent = userInput.inputInteger();
                    userInput.inputString(); // Consume the newline character
                    programOutput.printMessage("Genre: \n");
                    String genreSeries = userInput.inputString();
                    String typeS = "Series";
                    Product newSeriesProduct = new Series( titleSeries,  yearOfAppearanceSeries,  durationOfEpisode,  directorSeries,  ageRestrictionSeries, priceRent,genreSeries,typeS);

                   //update list of products
                    list.addToList(newSeriesProduct);

                    data.insertProductToDB(newSeriesProduct);

                    programOutput.printMessage("Series was added to the collection.\n");
                    programOutput.printMessage("\n");
                    break;


                case 4://display collection of products

                    data.displayProductsFromDB();
                    break;


                case 5://delete product
                    programOutput.printMessage("Title of the product you want to delete: \n");
                    String delProduct = userInput.inputString();
                    ArrayList<Product> delProductList= list.searchProduct(delProduct);

                    data.deleteProduct(delProduct);

                    programOutput.printMessage("\n");
                    break;



                case 6://test


                    //ask for user input
                    programOutput.printMessage("Choose action: \ntest: \n1.Movie and Series constructors ;\n2.Product to Jason function and rent a series function.\n ");
                    int user = userInput.inputInteger();
                    userInput.inputString();
                    programOutput.printMessage("\n");

                    switch (user){

                        case 1://test Product to Json and Json to Product constructors
                            Thread thread1 = new Thread(new Task1());
                            Thread thread2 = new Thread(new Task2());


                            thread1.start();
                            thread2.start();


                            thread1.join();
                            thread2.join();


                            break;
                        case 2://test Movie and Series constructors
                            Thread thread3 = new Thread(new Task3());
                            Thread thread4 = new Thread(new Task4());


                            thread3.start();
                            thread4.start();


                            thread3.join();
                            thread4.join();


                            break;


                    }


                    break;

                case 7:
                    programOutput.printMessage("Username: \n");
                    String usernameAdd = userInput.inputString();

                    programOutput.printMessage("Password: \n");
                    String password = userInput.inputString();

                    if(usernameAdd.isEmpty() && password.isEmpty()){

                        programOutput.printMessage("Username or password can't be empty.");


                    }else{data.addUser(usernameAdd,password);}




                    break;

                case 8:
                    programOutput.printMessage("Username: \n");
                    String usernameRole = userInput.inputString();

                    programOutput.printMessage("User role: \n");
                    String role = userInput.inputString();

                    data.updateUserRole(usernameRole, role);

                    break;

                case 9:
                    programOutput.printMessage("Username: \n");
                    String usernameDel = userInput.inputString();

                    data.deleteUser(usernameDel);

                    break;

                case 10:

                    data.displayUsersFromDB();
                    break;

                case 0://exit program

                    //write in file list of products
                    ArrayList<Product> listObj = list.getProductList();
                    ArrayList<JSONObject> listJsObj = json.jsonObjectsList(listObj);
                    programOutput.listToFile(listJsObj);
                    run = false;
                    break;
            }

        }




    }
    public void user() throws IOException, ClassNotFoundException {

        //update list of objects
        ArrayList<JSONObject> listFromFile = programOutput.readFromFile();
        list.updateObjList(listFromFile);
        DatabaseLink data = new DatabaseLink();

        //run as operator
        boolean run = true;
        while (run) {

            //ask input from user
            programOutput.printMessage("Choose action: \n1.search product;\n2.display products;\n3.buy a movie;\n4.rent a series;\n0.exit program.\n ");
            int userChoise = userInput.inputInteger();
            userInput.inputString();
            programOutput.printMessage("\n");
            switch (userChoise) {


                case 1://search for product
                    programOutput.printMessage("Product name: \n");
                    String productName = userInput.inputString();

                    if (data.checkSpecificObjectFromDB(productName)
                    ) {
                        programOutput.printMessage("Product "+ productName + " found in the collection.\n");

                    } else {
                        programOutput.printMessage("Product not found.\n");

                    }
                    programOutput.printMessage("\n");
                    break;


                case 2://display list of products

                    data.displayProductsFromDB();
                    programOutput.printMessage("\n");
                    break;


                case 3://buy a movie
                    ArrayList<Product> productListM = list.displayList();
                    programOutput.printMessage("Name of the movie: \n");
                    String nameMovie = userInput.inputString();
                    ArrayList<Product> listSameProductsM = list.searchProduct(nameMovie);
                    try {

                        if (data.getProductType(nameMovie).equals("Movie")) {

                            programOutput.printMessage("Movie found in the collection.\n");

                            int price = listSameProductsM.get(0).getPrice();

                            programOutput.printMessage("It will cost you " + price + " lei. ");
                            programOutput.printMessage("If you want to complete the purchase write 'yes', else write 'no'.\n");
                            String answer = userInput.inputString();

                            boolean loop = true;
                            while (loop){
                                if (answer.equals("yes")){
                                    data.deleteProduct(nameMovie);

                                    programOutput.printMessage("Movie was purchased");
                                    loop = false;
                                } else if (answer.equals("no")) {
                                    loop = false;
                                }else{
                                    programOutput.printMessage("Invalid answer.\n");
                                    loop = false;
                                }
                            }



                        } else {
                            programOutput.printMessage("Product not found.\n");

                        }
                    } catch (ClassCastException e) {
                        System.err.println("Error: Product received not movie type.");
                        e.printStackTrace();
                    }
                    programOutput.printMessage("\n");
                    break;


                case 4://rent a series

                    programOutput.printMessage("Name of the series: \n");
                    String nameSeries = userInput.inputString();
                    ArrayList<Product> listSameProductsS = list.searchProduct(nameSeries);

                    if (listSameProductsS.isEmpty()) {
                        programOutput.printMessage("Product not found.\n");
                        break;
                    }
                    try {
                        if (listSameProductsS.get(0) instanceof Series) {
                            boolean state = ((Series) listSameProductsS.get(0)).getRentness();
                            boolean loop = true;
                            while (loop) {
                                if (!state) {
                                    programOutput.printMessage("Series found in the collection.\n");
                                    int price = ( listSameProductsS.get(0)).getPrice();
                                    programOutput.printMessage("It will cost you " + (price/12)*2 + " lei per month. \n");
                                    programOutput.printMessage("If you want to complete the purchase write 'yes', else write 'no'.\n");
                                    String answer = userInput.inputString();
                                    if (answer.equals("yes")) {
                                        ((Series) listSameProductsS.get(0)).rentSeries();
                                        programOutput.printMessage("Series rented successfully.\n");
                                        loop = false;
                                    } else if (answer.equals("no")) {
                                        loop = false;
                                    }else{
                                        programOutput.printMessage("Invalid answer try again.\n");
                                    }
                                } else{
                                    programOutput.printMessage("Series already rented.\n");
                                    loop = false;
                                }
                            }
                        }
                    }catch(ClassCastException er){
                        System.err.println("Error: Movies can't be rented.");
                        er.printStackTrace();
                    }
                    programOutput.printMessage("\n");
                    break;

                case 0://exit program

                    //write list of products in file
                    ArrayList<Product> listObj = list.getProductList();
                    ArrayList<JSONObject> listJsObj = json.jsonObjectsList(listObj);
                    programOutput.listToFile(listJsObj);
                    run = false;
                    break;
            }
        }
    }

}
