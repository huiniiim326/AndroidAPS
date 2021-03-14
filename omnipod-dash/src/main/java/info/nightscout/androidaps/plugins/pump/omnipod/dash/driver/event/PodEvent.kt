package info.nightscout.androidaps.plugins.pump.omnipod.dash.driver.event

import info.nightscout.androidaps.plugins.pump.omnipod.dash.driver.comm.Id
import info.nightscout.androidaps.plugins.pump.omnipod.dash.driver.pod.command.base.Command
import info.nightscout.androidaps.plugins.pump.omnipod.dash.driver.pod.response.Response

sealed class PodEvent {

    /* BT connection events */
    class AlreadyConnected(val bluetoothAddress: String) : PodEvent()
    object AlreadyPaired : PodEvent()
    object Scanning : PodEvent()
    object BluetoothConnecting : PodEvent()
    class BluetoothConnected(val bluetoothAddress: String) : PodEvent()
    object Pairing : PodEvent()
    class Paired(val uniqueId: Id) : PodEvent()
    object EstablishingSession : PodEvent()
    object Connected : PodEvent()

    /* Message exchange events */
    class CommandSending(val command: Command) : PodEvent()
    class CommandSent(val command: Command) : PodEvent()
    class ResponseReceived(val response: Response) : PodEvent()
}