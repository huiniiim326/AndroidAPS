package info.nightscout.androidaps.plugins.pump.insight.app_layer.status

import info.nightscout.androidaps.plugins.pump.insight.app_layer.AppLayerMessage
import info.nightscout.androidaps.plugins.pump.insight.app_layer.Service
import info.nightscout.androidaps.plugins.pump.insight.descriptors.MessagePriority
import info.nightscout.androidaps.plugins.pump.insight.utils.ByteBuf

class GetPumpStatusRegisterMessage : AppLayerMessage(MessagePriority.NORMAL, false, false, Service.STATUS) {

    internal var isOperatingModeChanged = false
        private set
    internal var isBatteryStatusChanged = false
        private set
    internal var isCartridgeStatusChanged = false
        private set
    internal var isTotalDailyDoseChanged = false
        private set
    internal var isActiveBasalRateChanged = false
        private set
    internal var isActiveTBRChanged = false
        private set
    internal var isActiveBolusesChanged = false
        private set

    override fun parse(byteBuf: ByteBuf?) {
        byteBuf?.run {
            isOperatingModeChanged = readBoolean()
            isBatteryStatusChanged = readBoolean()
            isCartridgeStatusChanged = readBoolean()
            isTotalDailyDoseChanged = readBoolean()
            isActiveBasalRateChanged = readBoolean()
            isActiveTBRChanged = readBoolean()
            isActiveBolusesChanged = readBoolean()
        }
    }
}