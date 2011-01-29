package org.mobicents.protocols.ss7.m3ua.impl.message.ssnm;

import java.nio.ByteBuffer;

import org.mobicents.protocols.ss7.m3ua.impl.message.M3UAMessageImpl;
import org.mobicents.protocols.ss7.m3ua.impl.parameter.ParameterImpl;
import org.mobicents.protocols.ss7.m3ua.message.MessageClass;
import org.mobicents.protocols.ss7.m3ua.message.MessageType;
import org.mobicents.protocols.ss7.m3ua.message.ssnm.SignallingCongestion;
import org.mobicents.protocols.ss7.m3ua.parameter.AffectedPointCode;
import org.mobicents.protocols.ss7.m3ua.parameter.ConcernedDPC;
import org.mobicents.protocols.ss7.m3ua.parameter.CongestedIndication;
import org.mobicents.protocols.ss7.m3ua.parameter.InfoString;
import org.mobicents.protocols.ss7.m3ua.parameter.NetworkAppearance;
import org.mobicents.protocols.ss7.m3ua.parameter.Parameter;
import org.mobicents.protocols.ss7.m3ua.parameter.RoutingContext;

/**
 * 
 * @author amit bhayani
 *
 */
public class SignallingCongestionImpl extends M3UAMessageImpl implements
        SignallingCongestion {

    public SignallingCongestionImpl() {
        super(MessageClass.SIGNALING_NETWORK_MANAGEMENT,
                MessageType.SIGNALING_CONGESTION);
    }

    public AffectedPointCode getAffectedPointCodes() {
        return (AffectedPointCode) parameters
                .get(ParameterImpl.Affected_Point_Code);
    }

    public InfoString getInfoString() {
        return (InfoString) parameters.get(ParameterImpl.INFO_String);
    }

    public NetworkAppearance getNetworkAppearance() {
        return (NetworkAppearance) parameters
                .get(ParameterImpl.Network_Appearance);
    }

    public RoutingContext getRoutingContexts() {
        return (RoutingContext) parameters.get(ParameterImpl.Routing_Context);
    }

    public void setAffectedPointCodes(AffectedPointCode afpc) {
        parameters.put(ParameterImpl.Affected_Point_Code, afpc);
    }

    public void setInfoString(InfoString str) {
        parameters.put(ParameterImpl.INFO_String, str);
    }

    public void setNetworkAppearance(NetworkAppearance p) {
        parameters.put(ParameterImpl.Network_Appearance, p);
    }

    public void setRoutingContexts(RoutingContext routingCntx) {
        parameters.put(ParameterImpl.Routing_Context, routingCntx);
    }

    public ConcernedDPC getConcernedDPC() {
        return (ConcernedDPC) parameters
                .get(ParameterImpl.Concerned_Destination);
    }

    public CongestedIndication getCongestedIndication() {
        return (CongestedIndication) parameters
                .get(ParameterImpl.Congestion_Indications);
    }

    public void setConcernedDPC(ConcernedDPC dpc) {
        parameters.put(ParameterImpl.Concerned_Destination, dpc);
    }

    public void setCongestedIndication(CongestedIndication congInd) {
        parameters.put(ParameterImpl.Congestion_Indications, congInd);
    }

    @Override
    protected void encodeParams(ByteBuffer buffer) {
        if (parameters.containsKey(Parameter.Network_Appearance)) {
            ((ParameterImpl) parameters.get(Parameter.Network_Appearance))
                    .write(buffer);
        }

        if (parameters.containsKey(Parameter.Routing_Context)) {
            ((ParameterImpl) parameters.get(Parameter.Routing_Context))
                    .write(buffer);
        }
        if (parameters.containsKey(Parameter.Affected_Point_Code)) {
            ((ParameterImpl) parameters.get(Parameter.Affected_Point_Code))
                    .write(buffer);
        }

        if (parameters.containsKey(Parameter.Concerned_Destination)) {
            ((ParameterImpl) parameters.get(Parameter.Concerned_Destination))
                    .write(buffer);
        }

        if (parameters.containsKey(Parameter.Congestion_Indications)) {
            ((ParameterImpl) parameters.get(Parameter.Congestion_Indications))
                    .write(buffer);
        }

        if (parameters.containsKey(Parameter.INFO_String)) {
            ((ParameterImpl) parameters.get(Parameter.INFO_String))
                    .write(buffer);
        }

    }

}
