package huishiji.xuexihui.hxx.entity;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Foreign;
import com.lidroid.xutils.db.annotation.Table;

/**
 * Created by Administrator on 2015/8/26.
 */
@Table(name ="hxx_konwledges")
public class Point {
    private Integer  _id;

    @Foreign(column = "kno_type" ,foreign = "_id")
    private PointType  pointType;

    @Column(column = "kno_content")
    private String content;

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PointType getPointType() {
        return pointType;
    }

    public void setPointType(PointType pointType) {
        this.pointType = pointType;
    }
}
