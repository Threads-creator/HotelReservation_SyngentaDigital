import java.util.*;

public class HotelReservation {

    private Set<Hotel> hotels = new HashSet<>();
    List<String> daysOfWeekend = new ArrayList<>(Arrays.asList("sat", "sun"));

    public HotelReservation(){
        this.hotels.add(new Hotel("Lakewood", 3, 110.0, 80.0, 90.0, 80.0));
        this.hotels.add(new Hotel("Bridgewood", 4, 160.0, 110.0, 60.0, 50.0));
        this.hotels.add(new Hotel("Ridgewood", 5, 220.0, 100.0, 150.0, 40.0));
    }


    public String getCheapestHotel (String input) {

        // get type client
        String typeClient = input.split(":")[0];

        // get dates
        String[] datasText = input.substring(typeClient.length() + 1).trim().split(",");

        // get days normals and weekend
        // Obs: não sei se foi intencional, mas achei meio estranho esse formato de Data sem espaços ou outro delimitador.
        // Então peguei apenas o dia da semada de cada data
        int qtdDaysNormals = 0;
        int qtdDaysWeekend = 0;

        for(int i = 0; i < datasText.length; i++){
            String day = datasText[i].substring( datasText[i].indexOf('(') + 1, datasText[i].indexOf(')'));

            if(daysOfWeekend.contains(day.toLowerCase())){
                qtdDaysWeekend++;
                continue;
            }
            qtdDaysNormals++;
        }


        if(typeClient.equalsIgnoreCase("regular") || typeClient.equalsIgnoreCase("regulars")){

            return cheapestHotelForRegularDays(qtdDaysNormals, qtdDaysWeekend).getName();

        }

        if(typeClient.equalsIgnoreCase("reward") || typeClient.equalsIgnoreCase("rewards")){

            return cheapestHotelForRewardDays(qtdDaysNormals, qtdDaysWeekend).getName();
        }

        return "";
    }


    private Hotel cheapestHotelForRegularDays(int qtdDaysNormals, int qtdDaysWeekend){
        double minPrice = Double.POSITIVE_INFINITY;
        double price = 0.0;
        Hotel cheapestHotel = null;

        Iterator<Hotel> iteratorHotel = hotels.iterator();

        while(iteratorHotel.hasNext()){
            Hotel actualHotel = iteratorHotel.next();

            price = priceForRegularDaysHotel(actualHotel, qtdDaysNormals, qtdDaysWeekend);

            if(price < minPrice){
                minPrice = price;
                cheapestHotel = actualHotel;
            }else if (price == minPrice){
                cheapestHotel = actualHotel.getStars() > cheapestHotel.getStars()? actualHotel : cheapestHotel;
            }

        }

        return cheapestHotel;
    }

    private double priceForRegularDaysHotel(Hotel hotel, int normalDays, int weekendDays){
        return (hotel.getTaxRegular() * normalDays) + (hotel.getTaxRegularWeekend() * weekendDays);
    }

    private Hotel cheapestHotelForRewardDays(int qtdDaysNormals, int qtdDaysWeekend){
        double minPrice = Double.POSITIVE_INFINITY;
        double price = 0.0;
        Hotel cheapestHotel = null;

        Iterator<Hotel> iteratorHotel = hotels.iterator();

        while(iteratorHotel.hasNext()){
            Hotel actualHotel = iteratorHotel.next();

            price = priceForRewardDaysHotel(actualHotel, qtdDaysNormals, qtdDaysWeekend);

            if(price < minPrice){
                minPrice = price;
                cheapestHotel = actualHotel;
            }else if (price == minPrice){
                cheapestHotel = actualHotel.getStars() > cheapestHotel.getStars()? actualHotel : cheapestHotel;
            }

        }

        return cheapestHotel;
    }

    private double priceForRewardDaysHotel(Hotel hotel, int normalDays, int weekendDays){
        return (hotel.getTaxReward() * normalDays) + (hotel.getTaxRewardWeekend() * weekendDays);
    }

}
