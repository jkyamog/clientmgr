package clientmgr.common;

public class Util {
   
   private Util() {}
   
   /**
    * compare 2 objects, return true if both are null otherwise
    * test of equality and return that result
    * 
    * @param obj1
    * @param obj2
    * @return
    */
   public static boolean areEqual(Object obj1, Object obj2) {
      
      if (obj1 == null) {
         return obj2 == null;
      } else {
         return obj1.equals(obj2);
      }
   }
   
   /**
    * given an array of objects, compute their hashCode my multiplying
    * w/ a prime no.  add the hashcode of the object
    * @param objects
    * @return
    */
   public static int calcHashCode(Object[] objects) {
      int hashCode = 1;
      for (int i=0; i < objects.length; i++) {
         hashCode = 31 * hashCode + (objects[i] == null ? 0 : objects[i].hashCode());
      }
      return hashCode;
   }


}
