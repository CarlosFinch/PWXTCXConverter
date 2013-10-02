/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PWXTCXConverter;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 *
 * @author m336080
 */
public class SampleDOM {
    
    public void sampledomrun(File fileabsolutepath_in, File fileabsolutepath_out) {
        try {
            File file = new File(fileabsolutepath_in.getAbsolutePath());
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            //verify if the file is real pwx
            if (doc.getDocumentElement().getNodeName().equals("pwx")) {
                //Time
                //Assumtion is to adding the <timeoffset> as seconds to time value to every iteration
                
                NodeList WorkoutList = doc.getElementsByTagName("workout");
                Node WorkoutNode = WorkoutList.item(0);
                Element WorkoutElmnt = (Element) WorkoutNode;
                
                NodeList TfstNmElmntLst = WorkoutElmnt.getElementsByTagName("time");
                Element TfstNmElmnt = (Element) TfstNmElmntLst.item(0);
                NodeList TfstNm = TfstNmElmnt.getChildNodes();
                String timer = TfstNm.item(0).getNodeValue();
                
                //creating the new file
                DocumentBuilderFactory docFactoryNew = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactoryNew.newDocumentBuilder();
                    //root elements
                    Document docnew = docBuilder.newDocument();
                    Element rootElement = docnew.createElement("TrainingCenterDatabase");
                    docnew.appendChild(rootElement);
                        //Set attribute to root element
                        //Shorten way
                        //setAttribute("id", "1");
                        Attr attr2 = docnew.createAttribute("xmlns");
                        attr2.setValue("http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2");
                        rootElement.setAttributeNode(attr2);

                        Attr attr1 = docnew.createAttribute("xmlns:xsd");
                        attr1.setValue("http://www.w3.org/2001/XMLSchema");
                        rootElement.setAttributeNode(attr1);

                        Attr attr = docnew.createAttribute("xmlns:xsi");
                        attr.setValue("http://www.w3.org/2001/XMLSchema-instance");
                        rootElement.setAttributeNode(attr);
                        //Activities elements
                        Element activities = docnew.createElement("Activities");
                        rootElement.appendChild(activities);                            
                        //Dynamic data...
                            //Activity
                            //Sport Type
                            NodeList SportTypeList = WorkoutElmnt.getElementsByTagName("sportType");
                            Element SportTypeElmnt = (Element) SportTypeList.item(0);
                            NodeList SportTypeNm = SportTypeElmnt.getChildNodes();
                            String SportType = SportTypeNm.item(0).getNodeValue();
                            //adding to tcx file - hardocded in line to documentation.
                            switch(SportType){
                                case "Run":
                                  SportType="Running";
                                  break;
                                case "Bike":
                                  SportType="Biking";
                                  break;
                                case "Swim":
                                  SportType="Swiming";
                                  break;               
                                default:
                                  SportType="Other";
                            }                                  
                            Element activity = docnew.createElement("Activity");
                            activities.appendChild(activity);
                            activity.setAttribute("sport", SportType);
                            //Lap and start time of the lap
                            Element Lap = docnew.createElement("Lap");
                            activity.appendChild(Lap);
                            Lap.setAttribute("StartTime", timer);                            
                            //From segment                            
                            NodeList SegmentList = WorkoutElmnt.getElementsByTagName("segment");
                            Node SegmentNode = SegmentList.item(0);
                            Element SegmentElmnt = (Element) SegmentNode;
                            //if there is no segment node - use summary or if there is more segmenets than 1.
                            //System.out.print(SegmentList.getLength());
                            if (SegmentList.getLength()!=1) {
                                //sumary data
                                NodeList SummaryDataList = WorkoutElmnt.getElementsByTagName("summarydata");
                                Node SummaryDataNode = SummaryDataList.item(0);
                                Element SummaryDataElmnt = (Element) SummaryDataNode;
                                    NodeList SummaryDurList = SummaryDataElmnt.getElementsByTagName("duration");
                                    Element SummaryDurElmnt = (Element) SummaryDurList.item(0);
                                    NodeList SummaryDurNm = SummaryDurElmnt.getChildNodes();
                                    String summaryduration = SummaryDurNm.item(0).getNodeValue();
                                    //save TotalTimeSeconds
                                    Element TotalTime = docnew.createElement("TotalTimeSeconds");
                                    TotalTime.appendChild(docnew.createTextNode(summaryduration));
                                    Lap.appendChild(TotalTime);
                                    //MaximumSpeed
                                    //How the max speed is counting?
                                    
                                    
                                    //DistanceMeters
                                    Element distancem = docnew.createElement("DistanceMeters");
                                    distancem.appendChild(docnew.createTextNode("0"));
                                    Lap.appendChild(distancem);
                                    //Intensity, TriggerMethod, Calories -> static values?
                                    //save
                                    Element calories = docnew.createElement("Calories");
                                    calories.appendChild(docnew.createTextNode("0"));
                                    Lap.appendChild(calories);
                                    Element intensity = docnew.createElement("Intensity");
                                    intensity.appendChild(docnew.createTextNode("Active"));
                                    Lap.appendChild(intensity);
                                    Element TriggerMethod = docnew.createElement("TriggerMethod");
                                    TriggerMethod.appendChild(docnew.createTextNode("Manual"));
                                    Lap.appendChild(TriggerMethod);  
                                    //JOptionPane.showMessageDialog(null,summaryduration);
                            } else {
                                //name from segment
                                NodeList LapNameList = SegmentElmnt.getElementsByTagName("name");
                                Element LapNameElmnt = (Element) LapNameList.item(0);
                                NodeList LapNameNm = LapNameElmnt.getChildNodes();
                                String segmentname = LapNameNm.item(0).getNodeValue();
                                //summarydata from segment - Not used yet
                                NodeList SegmentSummaryDataList = SegmentElmnt.getElementsByTagName("summarydata");
                                Node SegmentSummaryNode = SegmentSummaryDataList.item(0);
                                Element SegmentSummaryElmnt = (Element) SegmentSummaryNode;
                                    //duration
                                    NodeList DurationList = SegmentElmnt.getElementsByTagName("duration");
                                    Element DurationElmnt = (Element) DurationList.item(0);
                                    NodeList DurationNm = DurationElmnt.getChildNodes();
                                    String duration = DurationNm.item(0).getNodeValue();
                                    //save
                                    Element TotalTime = docnew.createElement("TotalTimeSeconds");
                                    TotalTime.appendChild(docnew.createTextNode(duration));
                                    Lap.appendChild(TotalTime);
                                    //dist from summarydata from segment
                                    NodeList DistList = SegmentElmnt.getElementsByTagName("dist");
                                    Element DistElmnt = (Element) DistList.item(0);
                                    NodeList DistNameNm = DistElmnt.getChildNodes();
                                    //Round
                                    int distanceInt = Math.round(Float.parseFloat(DistNameNm.item(0).getNodeValue()));
                                    String distance = Integer.toString(distanceInt);
                                    //save
                                    Element distanceM = docnew.createElement("DistanceMeters");
                                    distanceM.appendChild(docnew.createTextNode(distance));
                                    Lap.appendChild(distanceM);
                                    //spd attr=max, min, avg
                                    NodeList SpdList = SegmentElmnt.getElementsByTagName("spd");
                                    Element SpdElmnt = (Element) SpdList.item(0);
                                    NodeList SpdNm = SpdElmnt.getChildNodes();
                                    String speedmax = SpdElmnt.getAttribute("max");
                                    String speedmin = SpdElmnt.getAttribute("min");
                                    String speedavg = SpdElmnt.getAttribute("avg");
                                    //save
                                    Element speedMax = docnew.createElement("MaximumSpeed");
                                    speedMax.appendChild(docnew.createTextNode(speedmax));
                                    Lap.appendChild(speedMax);    
                                    //callories = 0?
                                    //save
                                    Element calories = docnew.createElement("Calories");
                                    calories.appendChild(docnew.createTextNode("0"));
                                    Lap.appendChild(calories);
                                    //hr attr=avg, max, avg
                                    NodeList HrList = SegmentElmnt.getElementsByTagName("hr");
                                    Element HrElmnt = (Element) HrList.item(0);
                                    NodeList HrNm = HrElmnt.getChildNodes();
                                    int hrmaxInt = Math.round(Float.parseFloat(HrElmnt.getAttribute("max")));
                                    String hrmax = Integer.toString(hrmaxInt);
                                    int hrminInt = Math.round(Float.parseFloat(HrElmnt.getAttribute("min")));
                                    String hrmin = Integer.toString(hrminInt);
                                    int hrvavgInt = Math.round(Float.parseFloat(HrElmnt.getAttribute("avg")));
                                    String hravg = Integer.toString(hrvavgInt);                                    
                                    //save AverageHeartRateBpm
                                    Element hravgS = docnew.createElement("AverageHeartRateBpm");
                                    Lap.appendChild(hravgS);
                                        Element hravgval = docnew.createElement("Value");
                                        hravgval.appendChild(docnew.createTextNode(hravg));                                        
                                        hravgS.appendChild(hravgval);
                                    //save MaximumHeartRateBpm
                                    Element hrmaxS = docnew.createElement("MaximumHeartRateBpm");
                                    Lap.appendChild(hrmaxS);
                                        Element hrmaxval = docnew.createElement("Value");
                                        hrmaxval.appendChild(docnew.createTextNode(hrmax));
                                        hrmaxS.appendChild(hrmaxval);                                        
                                    //static - don't know what is it.
                                    //<Intensity>Active</Intensity>
                                    //<TriggerMethod>Manual</TriggerMethod>
                                    //save
                                    Element intensity = docnew.createElement("Intensity");
                                    intensity.appendChild(docnew.createTextNode("Active"));
                                    Lap.appendChild(intensity);
                                    Element TriggerMethod = docnew.createElement("TriggerMethod");
                                    TriggerMethod.appendChild(docnew.createTextNode("Manual"));
                                    Lap.appendChild(TriggerMethod);
                            } //end if
                                    //Track
                                    Element Track = docnew.createElement("Track");
                                    Lap.appendChild(Track);
                                    
                                    //Sample -> Track           
                                    NodeList nodeLst = doc.getElementsByTagName("sample");
                                    for (int s = 0; s < nodeLst.getLength(); s++) {
                                        Node fstNode = nodeLst.item(s);
                                        if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
                                            //TrackPoint
                                            Element TrackPoint = docnew.createElement("Trackpoint");
                                            Lap.appendChild(TrackPoint);
                                                Element fstElmnt = (Element) fstNode;
                                                //Position
                                                Element Position = docnew.createElement("Position");
                                                TrackPoint.appendChild(Position);
                                                //LatitudeDegrees
                                                NodeList fstNmElmntLst1 = fstElmnt.getElementsByTagName("lat");
                                                Element fstNmElmnt1 = (Element) fstNmElmntLst1.item(0);
                                                if (fstNmElmnt1!=null) { 
                                                    NodeList fstNm1 = fstNmElmnt1.getChildNodes();                    
                                                    String lat = fstNm1.item(0).getNodeValue();
                                                    //save
                                                    Element latE = docnew.createElement("LatitudeDegrees");
                                                    latE.appendChild(docnew.createTextNode(lat));
                                                    Position.appendChild(latE);
                                                }
                                                //LongitudeDegrees
                                                NodeList fstNmElmntLst2 = fstElmnt.getElementsByTagName("lon");
                                                Element fstNmElmnt2 = (Element) fstNmElmntLst2.item(0);
                                                if (fstNmElmnt2!=null) { 
                                                    NodeList fstNm2 = fstNmElmnt2.getChildNodes();                    
                                                    String lon = fstNm2.item(0).getNodeValue();
                                                    //save
                                                    Element lonE = docnew.createElement("LongitudeDegrees");
                                                    lonE.appendChild(docnew.createTextNode(lon));
                                                    Position.appendChild(lonE);
                                                }
                                                //AltitudeMeters
                                                NodeList fstNmElmntLst3 = fstElmnt.getElementsByTagName("alt");
                                                Element fstNmElmnt3 = (Element) fstNmElmntLst3.item(0);
                                                if (fstNmElmnt3!=null) { 
                                                    NodeList fstNm3 = fstNmElmnt3.getChildNodes();
                                                    //Round
                                                    int altInt = Math.round(Float.parseFloat(fstNm3.item(0).getNodeValue()));
                                                    String alt = Integer.toString(altInt);
                                                    //save
                                                    Element AltM = docnew.createElement("AltitudeMeters");
                                                    AltM.appendChild(docnew.createTextNode(alt));
                                                    TrackPoint.appendChild(AltM);
                                                }
                                                //DistanceMeters
                                                NodeList fstNmElmntLst4 = fstElmnt.getElementsByTagName("dist");
                                                Element fstNmElmnt4 = (Element) fstNmElmntLst4.item(0);
                                                if (fstNmElmnt4!=null) { 
                                                    NodeList fstNm4 = fstNmElmnt4.getChildNodes();   
                                                    //Round
                                                    int distInt = Math.round(Float.parseFloat(fstNm4.item(0).getNodeValue()));
                                                    String dist = Integer.toString(distInt);
                                                    //save
                                                    Element DistM = docnew.createElement("DistanceMeters");
                                                    DistM.appendChild(docnew.createTextNode(dist));
                                                    TrackPoint.appendChild(DistM);
                                                }
                                                //HeartRateBpm Value
                                                NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("hr");
                                                Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
                                                if (fstNmElmnt!=null) { 
                                                    NodeList fstNm = fstNmElmnt.getChildNodes();
                                                    String hr = fstNm.item(0).getNodeValue();                                               
                                                    //save
                                                    Element HartRate = docnew.createElement("HeartRateBpm");
                                                    TrackPoint.appendChild(HartRate);                                                  
                                                        Element HartRateValue = docnew.createElement("Value");
                                                        HartRateValue.appendChild(docnew.createTextNode(hr));
                                                        HartRate.appendChild(HartRateValue);
                                                }
                                                //<Time>2013-09-24T22:32:48</Time>
                                                NodeList fstNmElmntLst0 = fstElmnt.getElementsByTagName("timeoffset");
                                                Element fstNmElmnt0 = (Element) fstNmElmntLst0.item(0);
                                                NodeList fstNm0 = fstNmElmnt0.getChildNodes();
                                                String timeoffset = fstNm0.item(0).getNodeValue();
                                                //round the time offdset to the seconds. 
                                                long timeoffsetrounded = Math.round(Double.parseDouble(timeoffset)); 
                                                //System.out.println(timeoffsetrounded);
                                                //time looks like 2013-09-24T22:32:48, let's delete "T"
                                                //String timenoT = (timer.replace('T', ' '));
                                                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                                                Date date = formatter.parse(timer);                                      
                                                //to the miiliseconds adding secs and back to date
                                                long militime=date.getTime();
                                                long milisec=timeoffsetrounded*1000;
                                                Date afterAddingSecs = new Date(militime + milisec);
                                                String Timer_final = formatter.format(afterAddingSecs);
                                                //save                                       
                                                Element TimerE = docnew.createElement("Time");
                                                TimerE.appendChild(docnew.createTextNode(Timer_final));
                                                TrackPoint.appendChild(TimerE);
                                                
                                        }            
                                    }
                    //ID
                    Element ID = docnew.createElement("Id");
                    ID.appendChild(docnew.createTextNode(timer));
                    activity.appendChild(ID);
                    //author elements
                    Element author = docnew.createElement("Author");
                    rootElement.appendChild(author);
                    //set attribute to author element
                    author.setAttribute("xsi:type", "Application_t");
                    //name elements
                    Element name = docnew.createElement("Name");		
                    name.appendChild(docnew.createTextNode("www.sebastianzieba.com"));
                    author.appendChild(name);
                    //build elements
                    Element build = docnew.createElement("Build");		
                    author.appendChild(build);
                    //version elements
                    Element version = docnew.createElement("Version");		
                    build.appendChild(version);
                    //versionmajor elements
                    Element versionmajor = docnew.createElement("VersionMajor");
                    versionmajor.appendChild(docnew.createTextNode("1"));
                    version.appendChild(versionmajor);
                    //versionminor elements
                    Element versionminor = docnew.createElement("VersionMinor");
                    versionminor.appendChild(docnew.createTextNode("1"));
                    version.appendChild(versionminor);
                    //type element
                    Element type = docnew.createElement("Type");		
                    type.appendChild(docnew.createTextNode("Beta"));
                    build.appendChild(type);
                    // write the content into xml file
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    //format data/properties                        
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
                    DOMSource source = new DOMSource(docnew);
                    StreamResult result = new StreamResult(new File(fileabsolutepath_out.getAbsolutePath()));
                    transformer.transform(source, result);
                    //modal plus info
                    JOptionPane.showMessageDialog(null,"Convertion is finished.");
            } else {
                JOptionPane.showMessageDialog(null,"This is not pwx file.");
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"This is not a correct file or something went wrong. Error: "+e);
                //e.printStackTrace();
        }
    }
}
