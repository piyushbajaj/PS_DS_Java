package QueueExample;

import java.util.ArrayList;

/**
 * Created by piyush.bajaj on 24/09/16.
 */
public class QueuePetrolPump {


    // self defined
    public static class PetrolPump{
        private int petrol;
        private int distance;

        public PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }



        public int getPetrol() {
            return petrol;
        }

        private void setPetrol(int petrol) {
            this.petrol = petrol;
        }

        public int getDistance() {
            return distance;
        }

        private void setDistance(int distance) {
            this.distance = distance;
        }
    }

    public static int printTour(ArrayList<PetrolPump> petPump){
        int x, y;
        int start = 0;
        int end =  1;
        int size = petPump.size();

        int curr_petrol = petPump.get(start).getPetrol() - petPump.get(start).getDistance();

        while(end != start || curr_petrol < 0){
            while(curr_petrol < 0 && start != end){
                curr_petrol -= petPump.get(start).getPetrol() - petPump.get(start).getDistance();
                start = (start + 1) % size;

                if(start==0)
                    return -1;
            }

            curr_petrol += petPump.get(end).getPetrol() - petPump.get(end).getDistance();
            end = (end + 1) % size;
        }

        return start;
    }

    public static void main(String[] args) {

//        PetrolPump arr[][] =  {new PetrolPump(6,4), {3, 6}, {7, 3}};

        ArrayList<PetrolPump> petrolPumps = new ArrayList<>();
        petrolPumps.add(new PetrolPump(6,4));
        petrolPumps.add(new PetrolPump(3, 6));
        petrolPumps.add(new PetrolPump(7, 3));

        System.out.println("Array List of Petrol Pumps are: ");
        System.out.println(petrolPumps);
        System.out.println("Starting point of Petrol Pump is: ");
        System.out.println(printTour(petrolPumps));



//        for(int i=0;i<petrolPumps.size();i++){
//            PetrolPump petrolPump = petrolPumps.get(i);
//            petrolPump.petrol=10;       // error
//        }

    }
}

