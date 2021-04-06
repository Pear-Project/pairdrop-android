/*
 * SPDX-FileCopyrightText: 2015 Vineet Garg <grg.vineet@gmail.com>
 *
 * SPDX-License-Identifier: GPL-2.0-only OR GPL-3.0-only OR LicenseRef-KDE-Accepted-GPL
*/

package org.pear.pairdrop.Backends.LoopbackBackend;

import android.util.Log;

import org.pear.pairdrop.Backends.BasePairingHandler;
import org.pear.pairdrop.Device;
import org.pear.pairdrop.NetworkPacket;

public class LoopbackPairingHandler extends BasePairingHandler {

    public LoopbackPairingHandler(Device device, PairingHandlerCallback callback) {
        super(device, callback);
    }

    @Override
    public void packageReceived(NetworkPacket np) {

    }

    @Override
    public void requestPairing() {
        Log.i("LoopbackPairing", "requestPairing");
        mCallback.pairingDone();
    }

    @Override
    public void acceptPairing() {
        Log.i("LoopbackPairing", "acceptPairing");
        mCallback.pairingDone();
    }

    @Override
    public void rejectPairing() {
        Log.i("LoopbackPairing", "rejectPairing");
        mCallback.unpaired();
    }

    @Override
    public void unpair() {
        Log.i("LoopbackPairing", "unpair");
        mCallback.unpaired();
    }

}
