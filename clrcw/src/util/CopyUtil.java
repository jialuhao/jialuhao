package util;

import java.beans.PropertyDescriptor;
import java.util.Collection;

import org.apache.commons.beanutils.PropertyUtils;


/**
 * <p>
 * Description: 将源与目的之间copy相同的属性名。 而VO是在前台显示，所以难免会用到PO中所不存在的属性值。
 * 比如PO中可能是一个对象，而VO中则可能是此对象的全部属性。 其中的一些转换则需要依据前台需要针对性地处理啦
 * <p>
 * Company: 航天四创����˼��
 * </p>
 * 
 * @author 李滨���
 * 
 * @version 1.0
 */
public class CopyUtil {

	public static Object copyProperties(Object dest, Object orig) {
		if (dest == null || orig == null) {
			return dest;
		}

		PropertyDescriptor[] destDesc = PropertyUtils
				.getPropertyDescriptors(dest);
		try {
			for (int i = 0; i < destDesc.length; i++) {
				Class<?> destType = destDesc[i].getPropertyType();
				Class<?> origType = PropertyUtils.getPropertyType(orig,
						destDesc[i].getName());
				if (destType != null && destType.equals(origType)
						&& !destType.equals(Class.class)) {
					if (!Collection.class.isAssignableFrom(origType)) {
						try {
							Object value = PropertyUtils.getProperty(orig,
									destDesc[i].getName());
							PropertyUtils.setProperty(dest, destDesc[i]
									.getName(), value);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}
			}

			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dest;
	}

	/**
	 * 
	 * 描述：
	 * @param dest 目标对象
	 * @param orig 源对象
	 * @param ignores 忽略字段名称
	 * @return
	 */
	public static Object copyProperties(Object dest, Object orig,
			String[] ignores) {
		if (dest == null || orig == null) {
			return dest;
		}

		PropertyDescriptor[] destDesc = PropertyUtils
				.getPropertyDescriptors(dest);
		try {
			for (int i = 0; i < destDesc.length; i++) {
				if (contains(ignores, destDesc[i].getName())) {
					continue;
				}

				Class<?> destType = destDesc[i].getPropertyType();
				Class<?> origType = PropertyUtils.getPropertyType(orig,
						destDesc[i].getName());
				if (destType != null && destType.equals(origType)
						&& !destType.equals(Class.class)) {
					if (!Collection.class.isAssignableFrom(origType)) {
						Object value = PropertyUtils.getProperty(orig,
								destDesc[i].getName());
						PropertyUtils.setProperty(dest, destDesc[i].getName(),
								value);
					}
				}
			}

			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dest;
	}

	static boolean contains(String[] ignores, String name) {
		boolean ignored = false;
		for (int j = 0; ignores != null && j < ignores.length; j++) {
			if (ignores[j].equals(name)) {
				ignored = true;
				break;
			}
		}

		return ignored;
	}
}
