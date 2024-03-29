/*
 * Copyright (C) 2020 DV Bern AG, Switzerland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ch.dvbern.kibon.exchange.api.common.betreuung;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public enum BetreuungsAngebot {
	KITA,

	TAGESSCHULE,

	/**
	 * @deprecated only in schema &lt; 2.0
	 */
	@Deprecated
	@Schema(hidden = true, deprecated = true)
	TAGESELTERN_KLEINKIND,

	/**
	 * @deprecated only in schema &lt; 2.0
	 */
	@Deprecated
	@Schema(hidden = true, deprecated = true)
	TAGESELTERN_SCHULKIND,

	/**
	 * @deprecated only in schema &lt; 2.0
	 */
	@Deprecated
	@Schema(hidden = true, deprecated = true)
	TAGI,

	/**
	 * @since schema 2.0
	 */
	TAGESFAMILIEN,

	/**
	 * @since schema 2.0
	 */
	FERIENINSEL,
}
