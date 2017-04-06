<%@include file="/apps/foosball/champs/global.jsp"%>
<%@page import="org.apache.sling.commons.json.JSONArray,
                org.apache.sling.commons.json.JSONObject,
                org.apache.sling.commons.json.JSONException,
                java.util.*,
                javax.jcr.Node,
                com.day.cq.commons.jcr.*"
%>
<%
try {
      String nodePath="/content/qr/jcr:content";
      Resource resources = slingRequest.getResourceResolver().getResource(nodePath);
      Node rootNode = resources.adaptTo(Node.class);
      if(!rootNode.hasNode("destinations")) {
        rootNode.addNode("destinations");
        rootNode.save();
        out.println("Created root node: destinations");
      }
      nodePath += "/destinations";
      resources = slingRequest.getResourceResolver().getResource(nodePath);
      rootNode = resources.adaptTo(Node.class);

      // Validate input: One product per line
      String inputData = slingRequest.getParameter("destinations");
      if(inputData.isEmpty()) {
        throw new RuntimeException("Empty Destination data");
      }
      String[] lines = inputData.split("\n");
      if(lines.length < 1) {
        throw new RuntimeException("no data could be found");
      }

      // Validate each line of input. Copy valid data to repository. Report on every input line
      int count = 0;
      HashMap<String,String> report = new HashMap<>();
      for(String line : lines) {
        line = line.trim();
        if(line.isEmpty()) {
            continue;
        }
        if(!line.contains("=")) {
            report.put(line, "Skipped: Invalid input format");
            continue;
        }
        String[] destinationData = line.split("=");
        if(destinationData.length < 2) {
            report.put(line, "Skipped: Incomplete data");
            continue;
        }
        String destinationName = destinationData[0];
        Node destinationNode = null;
        if(rootNode.hasNode(destinationName)) {
            destinationNode = rootNode.getNode(destinationName);
        } else {
            destinationNode = rootNode.addNode(destinationName);
        }

        destinationNode.setProperty("data", destinationData[1]);
        destinationNode.save();
        rootNode.save();
        report.put(line, "Success: updated repository");
      }
      out.println(report.toString());
} catch (Exception ex) {
        out.println("Error: " + ex.toString());
}
%>
<hr>
<FORM>
    <INPUT Type="button" VALUE="Back" onClick="history.go(-1);return true;">
</FORM>
