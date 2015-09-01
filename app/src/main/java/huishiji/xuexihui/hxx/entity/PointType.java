package huishiji.xuexihui.hxx.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Finder;
import com.lidroid.xutils.db.annotation.Table;

import java.util.List;

/**
 * Created by Administrator on 2015/8/26.
 */
@Table(name ="hxx_knotype")
public class PointType {

    private Integer  _id;

    @Column( column = "ktype_name")
    private  String typeName;

    @Finder(valueColumn = "_id" ,targetColumn = "kno_type")
    List<Point> pointList;


    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public List<Point> getPointList() {
        return pointList;
    }

    public void setPointList(List<Point> pointList) {
        this.pointList = pointList;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
