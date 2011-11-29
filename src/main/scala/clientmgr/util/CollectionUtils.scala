package clientmgr.util

import scala.collection.JavaConversions._

/**
 * common utils for dealing w/ collections.  
 * 
 * NOTE: make use of scala java conversions or converters first before adding any new code here
 * only add new methods here if none exists on standard scala library.  We do not want to maintain
 * our own code
 */
object CollectionUtils {
	
	/** Create an empty buffer if list is null, use this if Option, Some and None doesn't make sense
	 * otherwise use the option type
	 */
	def asBufferOrEmptyBuffer[T](list: java.util.List[T]): collection.mutable.Buffer[T] = {
		if (list == null) new collection.mutable.ArrayBuffer[T]
		else list.toBuffer
	}

}