// ORM class for table 'workflow_entry'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Wed Apr 29 00:53:57 PDT 2015
// For connector: org.apache.sqoop.manager.MySQLManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import com.cloudera.sqoop.lib.JdbcWritableBridge;
import com.cloudera.sqoop.lib.DelimiterSet;
import com.cloudera.sqoop.lib.FieldFormatter;
import com.cloudera.sqoop.lib.RecordParser;
import com.cloudera.sqoop.lib.BooleanParser;
import com.cloudera.sqoop.lib.BlobRef;
import com.cloudera.sqoop.lib.ClobRef;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class workflow_entry extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  protected ResultSet __cur_result_set;
  private String registryId;
  public String get_registryId() {
    return registryId;
  }
  public void set_registryId(String registryId) {
    this.registryId = registryId;
  }
  public workflow_entry with_registryId(String registryId) {
    this.registryId = registryId;
    return this;
  }
  private String workflowId;
  public String get_workflowId() {
    return workflowId;
  }
  public void set_workflowId(String workflowId) {
    this.workflowId = workflowId;
  }
  public workflow_entry with_workflowId(String workflowId) {
    this.workflowId = workflowId;
    return this;
  }
  private String versionNo;
  public String get_versionNo() {
    return versionNo;
  }
  public void set_versionNo(String versionNo) {
    this.versionNo = versionNo;
  }
  public workflow_entry with_versionNo(String versionNo) {
    this.versionNo = versionNo;
    return this;
  }
  private String registorId;
  public String get_registorId() {
    return registorId;
  }
  public void set_registorId(String registorId) {
    this.registorId = registorId;
  }
  public workflow_entry with_registorId(String registorId) {
    this.registorId = registorId;
    return this;
  }
  private String registerTimeStamp;
  public String get_registerTimeStamp() {
    return registerTimeStamp;
  }
  public void set_registerTimeStamp(String registerTimeStamp) {
    this.registerTimeStamp = registerTimeStamp;
  }
  public workflow_entry with_registerTimeStamp(String registerTimeStamp) {
    this.registerTimeStamp = registerTimeStamp;
    return this;
  }
  private String registerNote;
  public String get_registerNote() {
    return registerNote;
  }
  public void set_registerNote(String registerNote) {
    this.registerNote = registerNote;
  }
  public workflow_entry with_registerNote(String registerNote) {
    this.registerNote = registerNote;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof workflow_entry)) {
      return false;
    }
    workflow_entry that = (workflow_entry) o;
    boolean equal = true;
    equal = equal && (this.registryId == null ? that.registryId == null : this.registryId.equals(that.registryId));
    equal = equal && (this.workflowId == null ? that.workflowId == null : this.workflowId.equals(that.workflowId));
    equal = equal && (this.versionNo == null ? that.versionNo == null : this.versionNo.equals(that.versionNo));
    equal = equal && (this.registorId == null ? that.registorId == null : this.registorId.equals(that.registorId));
    equal = equal && (this.registerTimeStamp == null ? that.registerTimeStamp == null : this.registerTimeStamp.equals(that.registerTimeStamp));
    equal = equal && (this.registerNote == null ? that.registerNote == null : this.registerNote.equals(that.registerNote));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof workflow_entry)) {
      return false;
    }
    workflow_entry that = (workflow_entry) o;
    boolean equal = true;
    equal = equal && (this.registryId == null ? that.registryId == null : this.registryId.equals(that.registryId));
    equal = equal && (this.workflowId == null ? that.workflowId == null : this.workflowId.equals(that.workflowId));
    equal = equal && (this.versionNo == null ? that.versionNo == null : this.versionNo.equals(that.versionNo));
    equal = equal && (this.registorId == null ? that.registorId == null : this.registorId.equals(that.registorId));
    equal = equal && (this.registerTimeStamp == null ? that.registerTimeStamp == null : this.registerTimeStamp.equals(that.registerTimeStamp));
    equal = equal && (this.registerNote == null ? that.registerNote == null : this.registerNote.equals(that.registerNote));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.registryId = JdbcWritableBridge.readString(1, __dbResults);
    this.workflowId = JdbcWritableBridge.readString(2, __dbResults);
    this.versionNo = JdbcWritableBridge.readString(3, __dbResults);
    this.registorId = JdbcWritableBridge.readString(4, __dbResults);
    this.registerTimeStamp = JdbcWritableBridge.readString(5, __dbResults);
    this.registerNote = JdbcWritableBridge.readString(6, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.registryId = JdbcWritableBridge.readString(1, __dbResults);
    this.workflowId = JdbcWritableBridge.readString(2, __dbResults);
    this.versionNo = JdbcWritableBridge.readString(3, __dbResults);
    this.registorId = JdbcWritableBridge.readString(4, __dbResults);
    this.registerTimeStamp = JdbcWritableBridge.readString(5, __dbResults);
    this.registerNote = JdbcWritableBridge.readString(6, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(registryId, 1 + __off, -1, __dbStmt);
    JdbcWritableBridge.writeString(workflowId, 2 + __off, -1, __dbStmt);
    JdbcWritableBridge.writeString(versionNo, 3 + __off, -1, __dbStmt);
    JdbcWritableBridge.writeString(registorId, 4 + __off, -1, __dbStmt);
    JdbcWritableBridge.writeString(registerTimeStamp, 5 + __off, -1, __dbStmt);
    JdbcWritableBridge.writeString(registerNote, 6 + __off, -1, __dbStmt);
    return 6;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeString(registryId, 1 + __off, -1, __dbStmt);
    JdbcWritableBridge.writeString(workflowId, 2 + __off, -1, __dbStmt);
    JdbcWritableBridge.writeString(versionNo, 3 + __off, -1, __dbStmt);
    JdbcWritableBridge.writeString(registorId, 4 + __off, -1, __dbStmt);
    JdbcWritableBridge.writeString(registerTimeStamp, 5 + __off, -1, __dbStmt);
    JdbcWritableBridge.writeString(registerNote, 6 + __off, -1, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.registryId = null;
    } else {
    this.registryId = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.workflowId = null;
    } else {
    this.workflowId = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.versionNo = null;
    } else {
    this.versionNo = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.registorId = null;
    } else {
    this.registorId = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.registerTimeStamp = null;
    } else {
    this.registerTimeStamp = Text.readString(__dataIn);
    }
    if (__dataIn.readBoolean()) { 
        this.registerNote = null;
    } else {
    this.registerNote = Text.readString(__dataIn);
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.registryId) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, registryId);
    }
    if (null == this.workflowId) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, workflowId);
    }
    if (null == this.versionNo) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, versionNo);
    }
    if (null == this.registorId) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, registorId);
    }
    if (null == this.registerTimeStamp) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, registerTimeStamp);
    }
    if (null == this.registerNote) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, registerNote);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.registryId) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, registryId);
    }
    if (null == this.workflowId) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, workflowId);
    }
    if (null == this.versionNo) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, versionNo);
    }
    if (null == this.registorId) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, registorId);
    }
    if (null == this.registerTimeStamp) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, registerTimeStamp);
    }
    if (null == this.registerNote) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    Text.writeString(__dataOut, registerNote);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(registryId==null?"null":registryId, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(workflowId==null?"null":workflowId, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(versionNo==null?"null":versionNo, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(registorId==null?"null":registorId, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(registerTimeStamp==null?"null":registerTimeStamp, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(registerNote==null?"null":registerNote, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(registryId==null?"null":registryId, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(workflowId==null?"null":workflowId, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(versionNo==null?"null":versionNo, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(registorId==null?"null":registorId, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(registerTimeStamp==null?"null":registerTimeStamp, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(registerNote==null?"null":registerNote, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.registryId = null; } else {
      this.registryId = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.workflowId = null; } else {
      this.workflowId = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.versionNo = null; } else {
      this.versionNo = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.registorId = null; } else {
      this.registorId = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.registerTimeStamp = null; } else {
      this.registerTimeStamp = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.registerNote = null; } else {
      this.registerNote = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.registryId = null; } else {
      this.registryId = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.workflowId = null; } else {
      this.workflowId = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.versionNo = null; } else {
      this.versionNo = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.registorId = null; } else {
      this.registorId = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.registerTimeStamp = null; } else {
      this.registerTimeStamp = __cur_str;
    }

    __cur_str = __it.next();
    if (__cur_str.equals("null")) { this.registerNote = null; } else {
      this.registerNote = __cur_str;
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    workflow_entry o = (workflow_entry) super.clone();
    return o;
  }

  public void clone0(workflow_entry o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new TreeMap<String, Object>();
    __sqoop$field_map.put("registryId", this.registryId);
    __sqoop$field_map.put("workflowId", this.workflowId);
    __sqoop$field_map.put("versionNo", this.versionNo);
    __sqoop$field_map.put("registorId", this.registorId);
    __sqoop$field_map.put("registerTimeStamp", this.registerTimeStamp);
    __sqoop$field_map.put("registerNote", this.registerNote);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("registryId", this.registryId);
    __sqoop$field_map.put("workflowId", this.workflowId);
    __sqoop$field_map.put("versionNo", this.versionNo);
    __sqoop$field_map.put("registorId", this.registorId);
    __sqoop$field_map.put("registerTimeStamp", this.registerTimeStamp);
    __sqoop$field_map.put("registerNote", this.registerNote);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if ("registryId".equals(__fieldName)) {
      this.registryId = (String) __fieldVal;
    }
    else    if ("workflowId".equals(__fieldName)) {
      this.workflowId = (String) __fieldVal;
    }
    else    if ("versionNo".equals(__fieldName)) {
      this.versionNo = (String) __fieldVal;
    }
    else    if ("registorId".equals(__fieldName)) {
      this.registorId = (String) __fieldVal;
    }
    else    if ("registerTimeStamp".equals(__fieldName)) {
      this.registerTimeStamp = (String) __fieldVal;
    }
    else    if ("registerNote".equals(__fieldName)) {
      this.registerNote = (String) __fieldVal;
    }
    else {
      throw new RuntimeException("No such field: " + __fieldName);
    }
  }
  public boolean setField0(String __fieldName, Object __fieldVal) {
    if ("registryId".equals(__fieldName)) {
      this.registryId = (String) __fieldVal;
      return true;
    }
    else    if ("workflowId".equals(__fieldName)) {
      this.workflowId = (String) __fieldVal;
      return true;
    }
    else    if ("versionNo".equals(__fieldName)) {
      this.versionNo = (String) __fieldVal;
      return true;
    }
    else    if ("registorId".equals(__fieldName)) {
      this.registorId = (String) __fieldVal;
      return true;
    }
    else    if ("registerTimeStamp".equals(__fieldName)) {
      this.registerTimeStamp = (String) __fieldVal;
      return true;
    }
    else    if ("registerNote".equals(__fieldName)) {
      this.registerNote = (String) __fieldVal;
      return true;
    }
    else {
      return false;    }
  }
}
